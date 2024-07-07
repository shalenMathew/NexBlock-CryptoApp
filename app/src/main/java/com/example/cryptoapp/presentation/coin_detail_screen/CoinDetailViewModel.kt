package com.example.cryptoapp.presentation.coin_detail_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.domain.usecases.getCoinUseCase.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
   savedStateHandle: SavedStateHandle)
    :ViewModel(){

    private val _state:MutableState<CoinDetailState> = mutableStateOf(CoinDetailState())
    val state:State<CoinDetailState> = _state

    init {
        val coinId = savedStateHandle.get<String>(Constants.PARAM_COIN_ID)
        val priceString = savedStateHandle.get<String>(Constants.PARAM_COIN_PRICE)
        val price = priceString?.toDoubleOrNull()

        val perc =savedStateHandle.get<String>(Constants.PARAM_COIN_PERC)
        getCoinDetail(coinId!!,price!!,perc!!)
    }

 private fun getCoinDetail(coinId:String,price:Double,per:String){

     getCoinUseCase(coinId).onEach {

            when(it){

                is Resource.Success->{
                    _state.value =   CoinDetailState(coin = it.data, price = price, per = per)
                }

                is Resource.Loading-> {
                    _state.value = CoinDetailState(isLoading = true)
                }

                is Resource.Error->{
                    _state.value=CoinDetailState(error = it.message ?: " Unknown error")
                }

            }
        }.launchIn(viewModelScope)

    }

}
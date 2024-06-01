package com.example.cryptoapp.presentation.coin_list_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.domain.usecases.getCoinListUseCase.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinListUseCase: GetCoinListUseCase ):ViewModel(){

    private val _state:MutableState<CoinState> = mutableStateOf(CoinState())
    val state:State<CoinState> = _state

    init {
        getCoinList()
    }

 private fun getCoinList(){

        getCoinListUseCase().onEach {

            when(it){

                is Resource.Success->{
                    _state.value =   CoinState(coinList = it.data ?: emptyList())
                }

                is Resource.Loading-> {
                    _state.value = CoinState(isLoading = true)
                }

                is Resource.Error->{
                    _state.value=CoinState(error = it.message ?: " Unknown error")
                }

            }
        }.launchIn(viewModelScope)

    }


}
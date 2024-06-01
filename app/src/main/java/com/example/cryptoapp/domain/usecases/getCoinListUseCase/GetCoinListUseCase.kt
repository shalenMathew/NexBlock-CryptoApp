package com.example.cryptoapp.domain.usecases.getCoinListUseCase

import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.domain.models.coinList.Coin
import com.example.cryptoapp.domain.models.coinPriceList.CoinPrice
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun  invoke():Flow<Resource<List<CoinPrice>>> = flow{


        try {
            emit(Resource.Loading())

//            val coinList = repository.getCoinList().map {
//                it.toCoin()
//            }

            val coinPriceList = repository.getCoinListByPrice().map {
                it.toCoinPrice()
            }

            emit(Resource.Success(coinPriceList))

        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }

    }

}
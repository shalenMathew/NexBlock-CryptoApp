package com.example.cryptoapp.domain.usecases.getCoinUseCase

import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.domain.models.coinDetail.CoinDetail
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke(coinId:String):Flow<Resource<CoinDetail>> = flow{

        try {
            emit(Resource.Loading())

            val coinDetail = coinRepository.getCoinById(coinId).toCoinDetail()


            emit(Resource.Success(coinDetail))

        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }

    }

}
package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.api.CoinApi
import com.example.cryptoapp.data.remote.dto.coinListDto.CoinDto
import com.example.cryptoapp.data.remote.dto.coinDetailDto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coinListWithPriceDto.CoinPriceDto
import com.example.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

// we can make the obj of a class by either telling hilt how to make the objects in module or using @inject constructor
class CoinRepositoryImpl
//@Inject constructor -> no need to use this as we providing the  instance of this class in module if we r using this annotation then we
// dont need to use provide fun in module but we need to Use @Bind annotation to tell hilt how to instantiate the interface
    (private val coinApi: CoinApi):CoinRepository {

    override suspend fun getCoinList(): List<CoinDto> {
        return  coinApi.getCoinList()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinApi.getCoinById(coinId)
    }

    override suspend fun getCoinListByPrice(): List<CoinPriceDto> {
        return coinApi.getCoinListWithPrice()
    }
}
package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.coinListDto.CoinDto
import com.example.cryptoapp.data.remote.dto.coinDetailDto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coinListWithPriceDto.CoinPriceDto

interface CoinRepository {

    //  ***  small mistake CoinDto is is an data model rather we should have the domain model Coin
    // will fix it later ***

   suspend fun getCoinList():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto

  suspend fun getCoinListByPrice():List<CoinPriceDto>

}
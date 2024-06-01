package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.coinListDto.CoinDto
import com.example.cryptoapp.data.remote.dto.coinDetailDto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coinListWithPriceDto.CoinPriceDto

interface CoinRepository {

   suspend fun getCoinList():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto

  suspend fun getCoinListByPrice():List<CoinPriceDto>

}
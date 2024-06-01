package com.example.cryptoapp.data.remote.api

import com.example.cryptoapp.data.remote.dto.coinListDto.CoinDto
import com.example.cryptoapp.data.remote.dto.coinDetailDto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coinListWithPriceDto.CoinPriceDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
   suspend fun getCoinList():List<CoinDto>

    @GET("/v1/coins/{coinId}")
   suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDto

   @GET("v1/tickers")
   suspend fun getCoinListWithPrice():List<CoinPriceDto>

}
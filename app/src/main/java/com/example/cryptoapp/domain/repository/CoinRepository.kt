package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.dto.coinListDto.CoinDto
import com.example.cryptoapp.data.remote.dto.coinDetailDto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.coinListWithPriceDto.CoinPriceDto
import com.example.cryptoapp.domain.models.coinDetail.CoinDetail
import com.example.cryptoapp.domain.models.coinList.Coin
import com.example.cryptoapp.domain.models.coinPriceList.CoinPrice

interface CoinRepository {

    //  ***  small mistake CoinDto is is a data model rather we should have the domain model Coin class
    // will fix it later ***

   suspend fun getCoinList():List<CoinDto>

    suspend fun getCoinById(coinId:String): CoinDetailDto

  suspend fun getCoinListByPrice():List<CoinPriceDto>

}
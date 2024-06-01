package com.example.cryptoapp.data.remote.dto.coinListWithPriceDto

import com.example.cryptoapp.domain.models.coinPriceList.CoinPrice

data class CoinPriceDto(
    val beta_value: Double,
    val first_data_at: String,
    val id: String,
    val last_updated: String,
    val max_supply: Long,
    val name: String,
    val quotes: QuotesDto,
    val rank: Int,
    val symbol: String,
    val total_supply: Long
){

    fun toCoinPrice():CoinPrice{
        return CoinPrice(
            id = id,
            name = name,
            usd =quotes.USD.toUSD(),
            rank=rank,
            symbol=symbol
        )
    }

}
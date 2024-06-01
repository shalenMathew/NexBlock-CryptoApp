package com.example.cryptoapp.domain.models.coinPriceList

import com.example.cryptoapp.data.remote.dto.coinListWithPriceDto.QuotesDto

data class CoinPrice(
    val id: String,
    val name: String,
    val usd: USD,
    val rank: Int,
    val symbol: String,
)

package com.example.cryptoapp.presentation.coin_list_screen

import com.example.cryptoapp.domain.models.coinList.Coin
import com.example.cryptoapp.domain.models.coinPriceList.CoinPrice

data class CoinState (
    val isLoading:Boolean=false,
    val error:String="",
    val coinList:List<CoinPrice> = emptyList(),
)
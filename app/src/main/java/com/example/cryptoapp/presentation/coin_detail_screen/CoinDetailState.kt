package com.example.cryptoapp.presentation.coin_detail_screen

import com.example.cryptoapp.domain.models.coinDetail.CoinDetail

data class CoinDetailState(

    val isLoading:Boolean=false,
    val error:String="",
    val coin: CoinDetail? = null,
    val price:Double?=null,
    val per:String=""
)

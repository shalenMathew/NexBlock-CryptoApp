package com.example.cryptoapp.data.remote.dto.coinListDto

import com.example.cryptoapp.domain.models.coinList.Coin


// this the the data model we will get when we fetch result from api
data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
){
    // this below function acts as a abstraction to communicate with domain layer without being directly interacting with it

    fun toCoin(): Coin {
        return Coin(
            id=id,
            isActive = is_active,
            name = name ,
            rank=rank,
            symbol = symbol
        )
    }

}
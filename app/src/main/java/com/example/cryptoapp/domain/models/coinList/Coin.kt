package com.example.cryptoapp.domain.models.coinList


// this is the data model what we want for the app
// this data model only include data from api which is needed for the business logic
// as this model deals with business logic its inside in domain layer

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

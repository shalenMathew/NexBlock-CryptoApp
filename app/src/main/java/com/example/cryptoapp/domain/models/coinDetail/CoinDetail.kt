package com.example.cryptoapp.domain.models.coinDetail

import com.example.cryptoapp.data.remote.dto.coinDetailDto.Links
import com.example.cryptoapp.data.remote.dto.coinDetailDto.Team

data class CoinDetail(
    val description: String?=null,
    val id: String?=null,
    val is_active: Boolean?=null,
    val links: Links?=null,
    val logo: String?=null,
    val name: String?=null,
    val rank: Int?=null,
    val tags: List<String>?=null,
    val team: List<Team>?=null,
    val whitepaper: WhitePaper?=null
)

package com.example.cryptoapp.data.remote.dto.coinDetailDto

import com.example.cryptoapp.domain.models.coinDetail.WhitePaper

data class WhitepaperResult(
    val link: String?,
    val thumbnail: String
){

// here WhitepaperResult have 2 parameters link and thumbnail, but we only we need
    // 'link' for our business logic

    fun toWhitePaper(): WhitePaper {
        return WhitePaper(
            link=link
        )
    }

}
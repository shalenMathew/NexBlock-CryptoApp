package com.example.cryptoapp.presentation.coin_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoapp.presentation.ui.theme.WhiteBlueFade


@Composable
fun Tags(
    tag:String
){

    Box(modifier= Modifier
        .clip(RoundedCornerShape(20.dp))
        .wrapContentSize()
        .background(color = WhiteBlueFade)
        , contentAlignment = Alignment.Center
    ){

Text(text = tag,
    color= Color.Black,
    modifier=Modifier.padding(start = 10.dp, end = 10.dp,top=5.dp,bottom=5.dp,))
    }

}

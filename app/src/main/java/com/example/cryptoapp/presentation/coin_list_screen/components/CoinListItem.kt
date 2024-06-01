package com.example.cryptoapp.presentation.coin_list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoapp.domain.models.coinPriceList.CoinPrice
import com.example.cryptoapp.presentation.ui.theme.DarkGreen
import com.example.cryptoapp.presentation.ui.theme.LightGreen
import com.example.cryptoapp.presentation.ui.theme.LightRed
import com.example.cryptoapp.presentation.ui.theme.YellowStart
import com.example.cryptoapp.presentation.ui.theme.osFontFamily


@Composable
fun CoinListItem(
    coin: CoinPrice,
    onItemClick:(CoinPrice)->Unit
){

Box(modifier = Modifier
    .padding(horizontal = 12.dp, vertical = 5.dp)
    .clip(RoundedCornerShape(20.dp))
    .fillMaxWidth()
    .height(85.dp)
    .background(YellowStart)
    .clickable {
        onItemClick(coin)
    }
){


    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween)
    {


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
            text = coin.name,
                fontFamily = osFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 23.sp,
                modifier= Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .width(170.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black)

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = coin.symbol,
                color = Color.Black,
                fontFamily = osFontFamily,
                fontWeight = FontWeight.Light,
                modifier=Modifier
                    .padding(start = 12.dp,
                        end = 12.dp))

        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {

            Text(
                text="$ " + String.format("%.4f",coin.usd.price),
                fontFamily = osFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier= Modifier
                    .padding(start = 12.dp, end = 12.dp),
                color = Color.Black)

            Spacer(modifier = Modifier.height(5.dp))


                if(coin.usd.percent_change_24h.toString().first() == '-'){

                    Box(modifier = Modifier
                        .padding(end=12.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(LightRed)) {

                        Text(text = coin.usd.percent_change_24h.toString() + "%",
                            color = Color.Red,
                            modifier=Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                    }

                }else{

                    Box(modifier = Modifier
                        .padding(end=12.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(LightGreen)) {

                        Text(text = "+" +coin.usd.percent_change_24h.toString() + "%",
                            color = DarkGreen,
                            modifier=Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                    }

                }

        }

    }

}

}
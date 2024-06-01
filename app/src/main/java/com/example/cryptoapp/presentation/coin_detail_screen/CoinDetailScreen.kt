package com.example.cryptoapp.presentation.coin_detail_screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.Coil
import coil.compose.rememberAsyncImagePainter
import com.example.cryptoapp.presentation.coin_detail_screen.components.Tags
import com.example.cryptoapp.presentation.coin_detail_screen.components.TeamListItem
import com.example.cryptoapp.presentation.coin_list_screen.CoinListViewModel
import com.example.cryptoapp.presentation.ui.theme.DarkGreen
import com.example.cryptoapp.presentation.ui.theme.LightGreen
import com.example.cryptoapp.presentation.ui.theme.LightRed
import com.example.cryptoapp.presentation.ui.theme.PurpleGrey40
import com.example.cryptoapp.presentation.ui.theme.PurpleGrey80
import com.example.cryptoapp.presentation.ui.theme.WhiteBlueFade
import com.example.cryptoapp.presentation.ui.theme.YellowStart
import com.example.cryptoapp.presentation.ui.theme.osFontFamily
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)){

        state.coin?.let {coin->

            LazyColumn(modifier=Modifier.fillMaxSize(),
                contentPadding = PaddingValues(10.dp)
            ){
                item {
                    Row(verticalAlignment = Alignment.CenterVertically){

                        if(!coin.logo.isNullOrEmpty()){

                            Image(painter = rememberAsyncImagePainter(coin.logo),
                                contentDescription ="logo",
                                modifier=Modifier.size(40.dp))
                        }

                        Spacer(modifier = Modifier.width(15.dp))

                        Text(text = coin.name!!,
                            color = Color.White,
                            fontFamily = osFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 35.sp,
                            maxLines = 2,
                            lineHeight =40.sp,
                            modifier = Modifier.fillMaxWidth())


                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier=Modifier.wrapContentSize()){

                        Text(
                            text= String.format("%.4f",state.price) + " USD",
                            fontFamily = osFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 23.sp,
                            modifier= Modifier
                                .padding( end = 10.dp),
                            color = Color.White)

                        Spacer(modifier = Modifier.width(5.dp))


                        if(state.per.first() == '-'){

                            Box(modifier = Modifier
                                .padding(end = 12.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightRed)) {

                                Text(text = state.per + "%",
                                    color = Color.Red,
                                    modifier=Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                            }

                        }else{

                            Box(modifier = Modifier
                                .padding(end = 12.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightGreen)) {

                                Text(text = "+" + state.per + "%",
                                    color = DarkGreen,
                                    modifier=Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = coin.description!!,
                        color = Color.White,
                        fontFamily = osFontFamily,
                        fontWeight = FontWeight.Light)

                    Spacer(modifier = Modifier.height(20.dp))

                    FlowRow(
                        mainAxisSpacing = 8.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth())
                    {
                        coin.tags?.forEach {tag->
                            Tags(tag = tag)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier
                        .border(width = 2.dp, color = WhiteBlueFade, RoundedCornerShape(8.dp))
                        .wrapContentHeight()
                        .fillMaxWidth()

                    ){



                        Column(modifier = Modifier
                            .padding(start = 12.dp)
                            .fillMaxSize()
                        , verticalArrangement = Arrangement.Center) {

                            val context = LocalContext.current

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(modifier=Modifier.fillMaxWidth()) {

                                Text(text = "Website : ",
                                    color= Color.White,
                                    fontFamily = osFontFamily,
                                    fontWeight = FontWeight.SemiBold
                                    )

                                Text(
                                    text = coin.links!!.website[0],
                                    color = Color.Green,
                                    modifier = Modifier
                                        .clickable {
                                            val url = coin.links.website[0]
                                            val intent = Intent(Intent.ACTION_VIEW)
                                            intent.data = Uri.parse(url)
                                            context.startActivity(intent)
                                        }
                                    ,fontWeight = FontWeight.Light

                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(modifier=Modifier.fillMaxWidth()){

                                Text(text = "Whitepaper : ",
                                    color= Color.White,
                                    fontFamily = osFontFamily,
                                    fontWeight = FontWeight.SemiBold
                                )

                                if(!coin.whitepaper!!.link.isNullOrEmpty()){
                                    Text(
                                        text = "Download white paper !!!",
                                        color = Color.Green,
                                        modifier = Modifier
                                            .clickable {
                                                val url = coin.whitepaper.link
                                                val intent = Intent(Intent.ACTION_VIEW)
                                                intent.data = Uri.parse(url)
                                                context.startActivity(intent)
                                            }
                                        , fontWeight = FontWeight.Light
                                    )
                                }else{
                                    Text(
                                        text = "No white paper found",
                                        color = Color.White,
                                       fontFamily = osFontFamily,
                                        fontWeight = FontWeight.Light
                                    )
                                }

                            }

                            Spacer(modifier = Modifier.height(10.dp))

                        }

                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Team Members :",
                        fontSize = 25.sp,
                        color = Color.White,
                        fontFamily = osFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }

                if (!coin.team.isNullOrEmpty()){
                    items(coin.team){ team->
                        TeamListItem(teamMember = team)
                    }
                }else{
                    item {
                        Text(text = "No Info",
                            fontFamily = osFontFamily,
                            fontWeight = FontWeight.Normal)
                        HorizontalDivider()
                    }
                }
            }

        }


        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}
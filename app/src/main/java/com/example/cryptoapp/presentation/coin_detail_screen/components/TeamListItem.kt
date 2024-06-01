package com.example.cryptoapp.presentation.coin_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoapp.data.remote.dto.coinDetailDto.Team
import com.example.cryptoapp.presentation.ui.theme.osFontFamily

@Composable
fun TeamListItem(
    teamMember:Team
){

Column(modifier= Modifier
    .padding(5.dp)
    .fillMaxWidth()
    .wrapContentHeight()) {

Text(text = teamMember.name,
    color = Color.White,
    fontFamily = osFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(text = teamMember.position,
        color = Color.White,
        fontFamily = osFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp
    )

    HorizontalDivider()

}

}
package com.example.cryptoapp.presentation.coin_list_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptoapp.presentation.Screen
import com.example.cryptoapp.presentation.coin_list_screen.components.CoinListItem

@Composable
fun CoinScreenList(
    navController:NavController,
    viewModel:CoinListViewModel= hiltViewModel()
){

   val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(state.coinList) { coin ->
                CoinListItem(
                    coin = coin, onItemClick = {

                        navController.navigate(Screen.CoinDetailScreen.route + "/${it.id}/${it.usd.price}/${it.usd.percent_change_24h}")
                    })
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
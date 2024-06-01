package com.example.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoapp.presentation.coin_detail_screen.CoinDetailScreen
import com.example.cryptoapp.presentation.coin_list_screen.CoinScreenList
import com.example.cryptoapp.presentation.coin_list_screen.components.CoinListItem
import com.example.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                SetBarColor(color = Color.Black)

                Surface(modifier=Modifier.background(color = Color.Black)) {
                    val navController = rememberNavController()

                  NavHost(navController = navController,
                      startDestination = Screen.CoinListScreen.route) {

                      composable(route=Screen.CoinListScreen.route){ CoinScreenList(navController = navController) }
                      composable(route = Screen.CoinDetailScreen.route + "/{coinId}/{coinPrice}/{coinPer}"){ CoinDetailScreen()}

                  }

                }

            }
        }
    }

    @Composable
    fun SetBarColor(color: Color){
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }

}


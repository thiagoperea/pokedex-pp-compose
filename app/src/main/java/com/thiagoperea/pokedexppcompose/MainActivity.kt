package com.thiagoperea.pokedexppcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.PokeDetailScreen
import com.thiagoperea.pokedexppcompose.ui.theme.PokedexComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { paddingValues ->

                    PokeDetailScreen()
                }
            }
        }
    }
}
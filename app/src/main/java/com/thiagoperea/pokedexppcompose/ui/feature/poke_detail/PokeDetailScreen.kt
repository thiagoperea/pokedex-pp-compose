package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views.BackgroundView
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views.ForegroundView
import com.thiagoperea.pokedexppcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokeDetailScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {

        BackgroundView()
        ForegroundView()
    }
}

@Preview
@Composable
fun PreviewPokeDetailScreen(){
    PokedexComposeTheme {
        Surface {
            PokeDetailScreen()
        }
    }
}

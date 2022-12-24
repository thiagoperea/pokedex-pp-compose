package com.thiagoperea.pokedexppcompose.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun PokedexComposeTheme(
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    LaunchedEffect(systemUiController) {

        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }

    MaterialTheme(
        typography = Typography,
        content = content
    )
}
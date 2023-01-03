package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thiagoperea.pokedexppcompose.ui.theme.AppColors


@Composable
fun ForegroundView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DetailsTitleBar()

        AsyncImage(
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(fraction = 0.5f) // square image with size beign 50% of screen's width
                .aspectRatio(1f) // aspect ratio makes the height the same as the width
                .padding(top = 24.dp)
        )

        Spacer(Modifier.height(16.dp))
        DetailsTypeList()

        Spacer(Modifier.height(16.dp))
        Text(
            text = "About",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.grass
        )

        Spacer(Modifier.height(16.dp))
        DetailsAboutContent()

        Spacer(Modifier.height(16.dp))
        Text(
            text= "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = "Base Stats",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.grass
        )

        Spacer(Modifier.height(16.dp))
        DetailsBaseStatsList(
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.R

@Composable
fun DetailsTitleBar(
    modifier: Modifier = Modifier
){

    Row(
        modifier = modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White)
        )

        Text(
            text = "Bulbasaur",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 16.dp),
        )

        Text(
            text = "#001",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
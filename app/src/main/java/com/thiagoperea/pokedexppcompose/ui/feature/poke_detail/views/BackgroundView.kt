package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thiagoperea.pokedexppcompose.R
import com.thiagoperea.pokedexppcompose.ui.theme.grass

@Composable
fun BackgroundView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grass),
        horizontalAlignment = Alignment.End
    ) {
        Image(
            painter = painterResource(R.drawable.ic_pokeball),
            contentDescription = null,
            modifier = Modifier.padding(top = 8.dp, end = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        )
    }
}
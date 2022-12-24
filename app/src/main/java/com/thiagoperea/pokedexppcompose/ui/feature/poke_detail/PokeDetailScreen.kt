package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thiagoperea.pokedexppcompose.R
import com.thiagoperea.pokedexppcompose.ui.theme.grass
import com.thiagoperea.pokedexppcompose.ui.theme.poison

@Composable
fun PokeDetailScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {

        BackgroundLayer()

        ForegroundLayer()
    }
}

@Composable
fun ForegroundLayer() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // TITLE BAR
        Row(
            modifier = Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp),
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

        // POKE IMAGE
        AsyncImage(
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(fraction = 0.5f) // square image with size beign 50% of screen's width
                .aspectRatio(1f) // aspect ratio makes the height the same as the width
                .padding(top = 24.dp)
        )

        // TYPES
        LazyRow {
            val types = listOf(
                "Grass" to grass,
                "Poison" to poison
            )

            items(types) { type ->
                Text(
                    text = type.first,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .background(type.second, shape = RoundedCornerShape(16.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        // ABOUT | TITLE
        Text(
            text = "About",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = grass,
            modifier = Modifier.padding(top = 16.dp)
        )

        // ABOUT | CONTENT
    }
}

@Composable
fun BackgroundLayer() {
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

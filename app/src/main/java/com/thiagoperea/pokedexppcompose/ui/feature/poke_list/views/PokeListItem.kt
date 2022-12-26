package com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thiagoperea.pokedexppcompose.data.model.PokeData
import com.thiagoperea.pokedexppcompose.ui.theme.PokedexComposeTheme
import com.thiagoperea.pokedexppcompose.ui.theme.grass

@Composable
fun PokeListItem(
    pokeData: PokeData
) {
    Column(
        modifier = Modifier
            .height(112.dp)
            .width(104.dp)
            .border(1.dp, grass, RoundedCornerShape(16.dp))
    ) {
        Text(
            text = pokeData.id.toString(),
            textAlign = TextAlign.End,
            fontSize = 10.sp,
            color = grass,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, end = 8.dp),
        )

        AsyncImage(
            model = pokeData.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        )

        Text(
            text = pokeData.name,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(grass)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewPokeListItem() {
    PokedexComposeTheme {
        Surface {
            val toShow = PokeData(1, "Bulbasaur", "grass", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png")

            PokeListItem(toShow)
        }
    }
}
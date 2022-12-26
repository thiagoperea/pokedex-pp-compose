package com.thiagoperea.pokedexppcompose.ui.feature.poke_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.pokedexppcompose.data.model.PokeData
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views.PokeListItem
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views.PokeListTopBar
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views.SearchField
import com.thiagoperea.pokedexppcompose.ui.theme.PokedexComposeTheme
import com.thiagoperea.pokedexppcompose.ui.theme.bgGray

@Composable
fun PokeListScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgGray)
            .padding(start = 24.dp, top = 32.dp, end = 24.dp),
    ) {

        PokeListTopBar()

        Spacer(Modifier.height(8.dp))
        SearchField()

        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            val mockDataset = listOf(
                PokeData(1, "Bulbasaur", "grass", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"),
                PokeData(2, "Ivysaur", "grass", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png"),
                PokeData(3, "Venusaur", "grass", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png"),
                PokeData(4, "Charmander", "fire", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"),
            )

            items(mockDataset) { pokeData ->
                PokeListItem(pokeData)
            }
        }
    }
}


@Preview
@Composable
fun PreviewPokeListScreen() {
    PokedexComposeTheme {
        Surface {
            PokeListScreen()
        }
    }
}

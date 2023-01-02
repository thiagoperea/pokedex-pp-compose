package com.thiagoperea.pokedexppcompose.ui.feature.poke_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thiagoperea.pokedexppcompose.data.model.PokeData
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views.PokeListItem
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views.PokeListTopBar
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views.SearchField
import com.thiagoperea.pokedexppcompose.ui.theme.bgGray

@Composable
fun PokeListScreenContent(
    modifier: Modifier = Modifier,
    pokeList: List<PokeData>,
    onEvent: (PokeListEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgGray)
            .padding(start = 24.dp, top = 32.dp, end = 24.dp),
    ) {

        PokeListTopBar(
            onSortClick = { onEvent(PokeListEvent.OnSortChange) }
        )

        Spacer(Modifier.height(8.dp))
        SearchField(
            onSearchTextChanged = { query ->
                onEvent(PokeListEvent.OnSearch(query))
            }
        )

        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(pokeList) { pokeData ->
                PokeListItem(pokeData)
            }
        }
    }
}
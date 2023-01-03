package com.thiagoperea.pokedexppcompose.ui.feature.poke_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.thiagoperea.pokedexppcompose.ui.theme.AppColors

@Composable
fun PokeListScreenContent(
    modifier: Modifier = Modifier,
    pokeList: List<PokeData>,
    onSearchSubmit: (String) -> Unit,
    onItemClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.bgGray)
    ) {

        PokeListTopBar(
            modifier = Modifier.padding(start = 24.dp, top = 32.dp, end = 24.dp),
        )

        SearchField(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp),
            onSearchTextChanged = { query -> onSearchSubmit(query) }
        )

        LazyVerticalGrid(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

            items(
                items = pokeList,
                key = { it.id }
            ) { pokeData ->

                PokeListItem(
                    modifier = Modifier.clickable { onItemClick(pokeData.id) },
                    data = pokeData
                )
            }
        }
    }
}
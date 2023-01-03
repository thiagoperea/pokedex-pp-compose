package com.thiagoperea.pokedexppcompose.ui.feature.poke_list

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.thiagoperea.pokedexppcompose.ui.LoadingBox
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokeListScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetails: (Int) -> Unit = {},
    viewModel: PokeListViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.setEvent(PokeListEvent.LoadScreen)
    }

    val state = viewModel.screenState.value

    Box(
        modifier = modifier
    ) {
        PokeListScreenContent(
            pokeList = state.pokeList,
            onSearchSubmit = { query ->
                viewModel.setEvent(PokeListEvent.OnSearch(query))
            },
            onItemClick = { id ->
                onNavigateToDetails(id)
            }
        )

        when (state) {
            is PokeListState.Loading -> {
                LoadingBox()
            }
            is PokeListState.Error -> {
//                ErrorMessage
            }
            else -> Unit
        }
    }
}
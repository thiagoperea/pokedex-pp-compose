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
    viewModel: PokeListViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.setEvent(PokeListEvent.LoadScreen)
    }

    val state = viewModel.screenState.value

    Box {
        PokeListScreenContent(
            pokeList = state.pokeList,
            onEvent = { event ->
                viewModel.setEvent(event)
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
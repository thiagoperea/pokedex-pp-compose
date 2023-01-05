package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.thiagoperea.pokedexppcompose.ui.LoadingBox
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokeDetailScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    viewModel: PokeDetailViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.setEvent(PokeDetailsEvent.LoadDetails)
    }

    val state = viewModel.screenState.value

    Box(
        modifier = modifier
    ) {
        PokeDetailsScreenContent(
            onNavigateBack = { onNavigateBack() },
            onNextPressed = { viewModel.setEvent(PokeDetailsEvent.LoadNext) },
            onPreviousPressed = { viewModel.setEvent(PokeDetailsEvent.LoadPrevious) },
            data = state.data
        )

        when (state) {
            is PokeDetailsState.Loading -> LoadingBox()
            is PokeDetailsState.Error -> Unit // ErrorMessage()
            is PokeDetailsState.Success -> Unit
        }
    }

}
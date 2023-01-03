package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views.BackgroundView
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views.ForegroundView
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokeDetailScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    viewModel: PokeDetailViewModel = koinViewModel()
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {

        BackgroundView()
        ForegroundView()
    }
}
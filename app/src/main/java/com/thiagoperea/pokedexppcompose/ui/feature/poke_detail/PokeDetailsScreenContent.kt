package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thiagoperea.pokedexppcompose.data.model.PokeData
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views.PokeDetailsBackground
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views.PokeDetailsForeground
import com.thiagoperea.pokedexppcompose.ui.theme.AppColors

@Composable
fun PokeDetailsScreenContent(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onNextPressed: () -> Unit,
    onPreviousPressed: () -> Unit,
    data: PokeData?
) {

    val typeColor = data?.typeList?.firstOrNull()?.color ?: AppColors.bgGray

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        PokeDetailsBackground(
            color = typeColor,
            showPreviousArrow = (data?.id ?: 0) > 1,
            onNextPressed = { onNextPressed() },
            onPreviousPressed = { onPreviousPressed() }
        )

        PokeDetailsForeground(
            onNavigateBack = { onNavigateBack() },
            data = data,
            color = typeColor
        )
    }
}

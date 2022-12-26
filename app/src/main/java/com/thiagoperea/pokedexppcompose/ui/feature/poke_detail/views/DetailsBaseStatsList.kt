package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsBaseStatsList(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        DetailsBaseStatsItem()
        DetailsBaseStatsItem()
        DetailsBaseStatsItem()
        DetailsBaseStatsItem()
        DetailsBaseStatsItem()
        DetailsBaseStatsItem()
    }
}
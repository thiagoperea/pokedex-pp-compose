package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.thiagoperea.pokedexppcompose.data.model.PokeDataStats

@Composable
fun DetailsBaseStatsList(
    modifier: Modifier = Modifier,
    stats: PokeDataStats?,
    color: Color
) {
    Column(
        modifier = modifier,
    ) {
        DetailsBaseStatsItem(color, "HP", stats?.hp ?: 0)
        DetailsBaseStatsItem(color, "ATK", stats?.atk ?: 0)
        DetailsBaseStatsItem(color, "DEF", stats?.def ?: 0)
        DetailsBaseStatsItem(color, "SATK", stats?.satk ?: 0)
        DetailsBaseStatsItem(color, "SDEF", stats?.sdef ?: 0)
        DetailsBaseStatsItem(color, "SPD", stats?.spd ?: 0)
    }
}
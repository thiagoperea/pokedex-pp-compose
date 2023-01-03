package com.thiagoperea.pokedexppcompose.data.model

import androidx.compose.ui.graphics.Color
import com.thiagoperea.pokedexppcompose.ui.theme.AppColors

enum class PokeType(val color: Color) {
    BUG(AppColors.bug),
    DARK(AppColors.dark),
    DRAGON(AppColors.dragon),
    ELECTRIC(AppColors.electric),
    FAIRY(AppColors.fairy),
    FIGHTING(AppColors.fighting),
    FIRE(AppColors.fire),
    FLYING(AppColors.flying),
    GHOST(AppColors.ghost),
    GRASS(AppColors.grass),
    GROUND(AppColors.ground),
    ICE(AppColors.ice),
    NORMAL(AppColors.normal),
    POISON(AppColors.poison),
    PSYCHIC(AppColors.psychic),
    ROCK(AppColors.rock),
    STEEL(AppColors.steel),
    WATER(AppColors.water)
}
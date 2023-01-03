package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class PokeDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val id: Int = savedStateHandle["id"] ?: 1


}
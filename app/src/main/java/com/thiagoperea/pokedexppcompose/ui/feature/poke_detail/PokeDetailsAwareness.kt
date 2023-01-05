package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import com.thiagoperea.pokedexppcompose.data.model.PokeData

sealed class PokeDetailsEvent {

    object LoadDetails : PokeDetailsEvent()

    object LoadNext : PokeDetailsEvent()

    object LoadPrevious : PokeDetailsEvent()
}

sealed class PokeDetailsState(val data: PokeData? = null) {

    object Loading : PokeDetailsState()

    data class Success(val response: PokeData) : PokeDetailsState(response)

    object Error : PokeDetailsState()
}
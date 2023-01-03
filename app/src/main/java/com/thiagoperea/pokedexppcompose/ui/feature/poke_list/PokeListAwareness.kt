package com.thiagoperea.pokedexppcompose.ui.feature.poke_list

import com.thiagoperea.pokedexppcompose.data.model.PokeData

sealed class PokeListEvent {

    object LoadScreen : PokeListEvent()

    data class OnSearch(val query: String) : PokeListEvent()

    data class OnItemClick(val id: Int) : PokeListEvent()
}

sealed class PokeListState(val pokeList: List<PokeData> = listOf()) {

    object Loading : PokeListState()

    data class Success(val loadedList: List<PokeData>) : PokeListState(loadedList)

    object Error : PokeListState()
}
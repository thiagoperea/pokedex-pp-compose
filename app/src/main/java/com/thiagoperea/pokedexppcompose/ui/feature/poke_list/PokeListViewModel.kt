package com.thiagoperea.pokedexppcompose.ui.feature.poke_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.pokedexppcompose.repository.PokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokeListViewModel(
    val repository: PokeRepository
) : ViewModel() {

    val screenState = mutableStateOf<PokeListState>(PokeListState.Loading)

    fun setEvent(event: PokeListEvent) {
        when (event) {
            is PokeListEvent.LoadScreen -> loadPokemons()
            is PokeListEvent.OnSearch -> searchQuery(event.query)
            is PokeListEvent.OnSortChange -> toggleSort()
        }
    }

    private fun loadPokemons() {
        viewModelScope.launch {

            try {
                val pokeList = withContext(Dispatchers.IO) {
                    repository.getAllPokemon()
                }
                screenState.value = PokeListState.Success(pokeList)
            } catch (error: Exception) {
                screenState.value = PokeListState.Error
            }
        }
    }

    private fun searchQuery(query: String) {

    }

    private fun toggleSort() {

    }
}
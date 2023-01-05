package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.pokedexppcompose.repository.PokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokeDetailViewModel(
    savedStateHandle: SavedStateHandle,
    val repository: PokeRepository
) : ViewModel() {

    var id: Int = savedStateHandle["id"] ?: 1
    val screenState = mutableStateOf<PokeDetailsState>(PokeDetailsState.Loading)

    fun setEvent(event: PokeDetailsEvent) {

        when (event) {
            PokeDetailsEvent.LoadDetails -> loadPokeDetails()
            PokeDetailsEvent.LoadNext -> {
                id++
                loadPokeDetails()
            }
            PokeDetailsEvent.LoadPrevious -> {
                id--
                loadPokeDetails()
            }
        }
    }

    private fun loadPokeDetails() {
        viewModelScope.launch {

            try {
                val details = withContext(Dispatchers.IO) {
                    repository.loadPokemonDetails(id)
                }

                screenState.value = PokeDetailsState.Success(details)
            } catch (error: Exception) {
                screenState.value = PokeDetailsState.Error
            }
        }
    }
}
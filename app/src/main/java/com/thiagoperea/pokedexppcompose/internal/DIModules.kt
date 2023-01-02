package com.thiagoperea.pokedexppcompose.internal

import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.PokeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DIModules {

    fun all() = listOf(viewModelModule)

    private val viewModelModule = module {

        viewModel { PokeListViewModel() }
    }
}
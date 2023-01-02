package com.thiagoperea.pokedexppcompose.internal

import com.thiagoperea.pokedexppcompose.data.remote.PokeApi
import com.thiagoperea.pokedexppcompose.repository.PokeRepository
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.PokeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DIModules {

    fun all() = listOf(
        dataModule,
        repositoryModule,
        viewModelModule
    )

    private val dataModule = module {
        // Remote API
        single {
            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokeApi::class.java)
        }

        // Local Database
    }

    private val repositoryModule = module {
        factory { PokeRepository(get()) }
    }

    private val viewModelModule = module {
        viewModel { PokeListViewModel(get()) }
    }
}
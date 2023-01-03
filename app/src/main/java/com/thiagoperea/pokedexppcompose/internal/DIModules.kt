package com.thiagoperea.pokedexppcompose.internal

import androidx.room.Room
import com.thiagoperea.pokedexppcompose.data.local.database.PokeDB
import com.thiagoperea.pokedexppcompose.data.remote.PokeApi
import com.thiagoperea.pokedexppcompose.repository.PokeRepository
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.PokeDetailViewModel
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.PokeListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
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
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { setLevel(Level.BODY) })
                .build()

            Retrofit.Builder()
                .client(httpClient)
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokeApi::class.java)
        }

        // Local Database
        single {
            Room.databaseBuilder(get(), PokeDB::class.java, "pokedex-db")
                .fallbackToDestructiveMigration()
                .build()
        }

        // DAOs
        factory { get<PokeDB>().pokeDataDao() }
    }

    private val repositoryModule = module {
        factory { PokeRepository(get(), get()) }
    }

    private val viewModelModule = module {
        viewModel { PokeListViewModel(get()) }

        viewModel { PokeDetailViewModel(get()) }
    }
}
package com.thiagoperea.pokedexppcompose.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET("pokemon/{id}")
    suspend fun getPokemonFromId(@Path("id") id: Int): PokemonResponse

    @GET("pokemon-species/{id}")
    suspend fun getDescription(@Path("id") id: Int): DescriptionResponse
}
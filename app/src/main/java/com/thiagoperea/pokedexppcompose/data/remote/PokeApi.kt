package com.thiagoperea.pokedexppcompose.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") startFromId: Int,
        @Query("limit") requestQuantity: Int = 30
    ): PokemonResponsePaginated

    @GET("pokemon/{id}")
    suspend fun getPokemonFromId(@Path("id") id: Int): PokemonResponse

    @GET("pokemon-species/{id}")
    suspend fun getDescription(@Path("id") id: Int): DescriptionResponse
}
package com.thiagoperea.pokedexppcompose.repository

import com.thiagoperea.pokedexppcompose.data.local.dao.PokeDataDao
import com.thiagoperea.pokedexppcompose.data.mapper.PokeDataMapper
import com.thiagoperea.pokedexppcompose.data.model.PokeData
import com.thiagoperea.pokedexppcompose.data.remote.PokeApi

class PokeRepository(
    val api: PokeApi,
    val database: PokeDataDao
) {

    var idToLoad = 1
    private val pagingSize = 30

    /**
     * Load pokemon list using local database first.
     * */
    suspend fun loadPokemonList(): List<PokeData> {
        val responseList = mutableListOf<PokeData>()

        try {
            repeat(pagingSize) {
                // Try to load data from local database
                val localData = database.getById(idToLoad)
                if (localData != null) {
                    responseList.add(localData)
                    idToLoad++
                    return@repeat
                }

                // Otherwise, load from backend
                val remoteData = api.getPokemonFromId(idToLoad)
                val mappedResponse = PokeDataMapper.map(remoteData)

                // Then save it to local database
                saveResponseToDatabase(mappedResponse)
                responseList.add(mappedResponse)
                idToLoad++
            }

            return responseList
        } catch (error: Exception) {
            //TODO: create a result wrapper
            error.printStackTrace()
            return responseList
        }
    }

    /**
     * Save backend response into database
     */
    private fun saveResponseToDatabase(response: PokeData) {
        database.insert(response)
    }
}
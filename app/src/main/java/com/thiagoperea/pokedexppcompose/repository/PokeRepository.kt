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
                database.insert(mappedResponse)
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

    suspend fun loadPokemonDetails(id: Int): PokeData {
        // Try to load data from database
        var data: PokeData? = database.getById(id)

        if (data == null) {
            val apiResponse = api.getPokemonFromId(id)
            data = PokeDataMapper.map(apiResponse)
            database.insert(data)
        }

        // Check if it need to load description
        if (data.description == null) {
            val apiResponse = api.getDescription(id)
            data.description = PokeDataMapper.mapDescription(apiResponse)
            // TODO: UPDATE MY DATABASE WITH THIS DATA
        }

        return data
    }
}
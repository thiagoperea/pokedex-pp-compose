package com.thiagoperea.pokedexppcompose.data.mapper

import com.thiagoperea.pokedexppcompose.data.model.PokeData
import com.thiagoperea.pokedexppcompose.data.model.PokeDataStats
import com.thiagoperea.pokedexppcompose.data.model.PokeType
import com.thiagoperea.pokedexppcompose.data.remote.PokemonResponse
import com.thiagoperea.pokedexppcompose.data.remote.PokemonStatsResponse
import com.thiagoperea.pokedexppcompose.data.remote.PokemonTypeResponse

object PokeDataMapper {

    fun map(backendResponse: PokemonResponse): PokeData {
        return PokeData(
            id = backendResponse.id,
            name = backendResponse.name,
            description = "",
            spriteUrl = backendResponse.sprites.frontUrl,
            officialUrl = backendResponse.sprites.otherUrls.officialUrl.url,
            typeList = mapTypeList(backendResponse.types),
            moveList = backendResponse.moves.take(2).map { it.move.name },
            weight = backendResponse.weight,
            height = backendResponse.height,
            stats = mapStats(backendResponse.stats)
        )
    }

    private fun mapStats(backendResponse: List<PokemonStatsResponse>) = PokeDataStats(
        hp = backendResponse.firstOrNull { it.description.name == "hp" }?.statValue ?: 0,
        atk = backendResponse.firstOrNull { it.description.name == "attack" }?.statValue ?: 0,
        def = backendResponse.firstOrNull { it.description.name == "defense" }?.statValue ?: 0,
        satk = backendResponse.firstOrNull { it.description.name == "special-attack" }?.statValue ?: 0,
        sdef = backendResponse.firstOrNull { it.description.name == "special-defense" }?.statValue ?: 0,
        spd = backendResponse.firstOrNull { it.description.name == "speed" }?.statValue ?: 0,
    )

    private fun mapTypeList(typeList: List<PokemonTypeResponse>) = typeList.map { enumValueOf<PokeType>(it.description.name.uppercase()) }
}
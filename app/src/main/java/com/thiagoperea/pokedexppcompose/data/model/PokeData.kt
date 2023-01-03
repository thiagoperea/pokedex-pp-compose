package com.thiagoperea.pokedexppcompose.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokeData(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val spriteUrl: String,
    val officialUrl: String,
    val typeList: List<PokeType>,
    val moveList: List<String>,
    val weight: Int,
    val height: Int,
    @Embedded val stats: PokeDataStats
)

data class PokeDataStats(
    val hp: Int,
    val atk: Int,
    val def: Int,
    val satk: Int,
    val sdef: Int,
    val spd: Int
)
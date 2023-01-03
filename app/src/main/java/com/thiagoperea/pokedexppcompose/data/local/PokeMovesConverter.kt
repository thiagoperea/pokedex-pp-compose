package com.thiagoperea.pokedexppcompose.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.thiagoperea.pokedexppcompose.internal.fromJson

class PokeMovesConverter {

    @TypeConverter
    fun fromList(moveList: List<String>): String = Gson().toJson(moveList)

    @TypeConverter
    fun toList(moveList: String): List<String> = Gson().fromJson(moveList)
}


package com.thiagoperea.pokedexppcompose.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.thiagoperea.pokedexppcompose.data.model.PokeType
import com.thiagoperea.pokedexppcompose.internal.fromJson

class PokeTypesConverter {

    @TypeConverter
    fun fromEnumList(types: List<PokeType>): String = Gson().toJson(types)

    @TypeConverter
    fun toEnumList(types: String): List<PokeType> = Gson().fromJson(types)
}
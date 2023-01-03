package com.thiagoperea.pokedexppcompose.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.thiagoperea.pokedexppcompose.data.local.PokeMovesConverter
import com.thiagoperea.pokedexppcompose.data.local.PokeTypesConverter
import com.thiagoperea.pokedexppcompose.data.local.dao.PokeDataDao
import com.thiagoperea.pokedexppcompose.data.model.PokeData

@Database(
    entities = [PokeData::class],
    version = 1,
)
@TypeConverters(
    value = [
        PokeTypesConverter::class,
        PokeMovesConverter::class
    ]
)
abstract class PokeDB : RoomDatabase() {

    abstract fun pokeDataDao(): PokeDataDao
}
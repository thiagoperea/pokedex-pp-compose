package com.thiagoperea.pokedexppcompose.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.thiagoperea.pokedexppcompose.data.model.PokeData

@Dao
interface PokeDataDao {

    @Query("SELECT * FROM PokeData")
    fun getAll(): List<PokeData>

    @Query("SELECT * FROM PokeData WHERE id = :id LIMIT 1")
    fun getById(id: Int): PokeData?

    @Insert
    fun insert(pokeData: PokeData)

    @Delete
    fun delete(pokeData: PokeData)
}
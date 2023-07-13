package com.example.supermathew.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonajeDao {

    @Insert
    suspend fun insert(personaje: PersonajeEntity)

    @Query("SELECT * FROM PersonajeEntity")
    suspend fun getAll(): List<PersonajeEntity>

}
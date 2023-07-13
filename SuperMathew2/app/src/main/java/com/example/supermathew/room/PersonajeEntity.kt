package com.example.supermathew.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PersonajeEntity")
data class PersonajeEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var nombre: String,
    var habilidad: String,
    var año: String
)
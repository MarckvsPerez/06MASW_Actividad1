package com.example.jetpackapp.viajesBD

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = "destinos")

data class Destino(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val hora: LocalTime
)
package com.example.jetpackapp.viajesBD

import android.app.usage.UsageEvents
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalTime
import com.example.jetpackapp.viajesBD.Destino


@Dao
interface DestinoDao {

    // Insertar un nuevo evento en la base de datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: UsageEvents.Event)

    // Obtiene todos los destinos en la tabla
    @Query("SELECT * FROM destinos ORDER BY hora ASC")
    fun getAllEvents(): Flow<List<UsageEvents.Event>>

    // Actualiza un destinos existente
    @Update
    suspend fun update(event: Destino)

    // Elimina un destinos específico
    @Delete
    suspend fun delete(event: Destino)

    // Borra todos los destinos de la tabla
    @Query("DELETE FROM destinos")
    suspend fun deleteAll()
}
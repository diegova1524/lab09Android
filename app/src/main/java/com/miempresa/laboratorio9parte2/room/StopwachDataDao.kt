package com.miempresa.laboratorio9parte2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.miempresa.laboratorio9parte2.model.Stopwatch
import  kotlinx.coroutines.flow.Flow

@Dao //Data access observer
interface StopwachDataDao {

    @Query("SELECT * FROM stopwach")
    fun getStopwatch(): Flow<List<Stopwatch>>

    @Query("SELECT * FROM stopwach WHERE id = :id")
    fun getStopwatchById(id:Long): Flow<Stopwatch>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stopwatch: Stopwatch)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(stopwatch: Stopwatch)

    @Delete
    suspend fun delete(stopwatch: Stopwatch)
}
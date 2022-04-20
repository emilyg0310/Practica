package com.example.practica

import androidx.room.*
import androidx.room.Entity

@Dao
interface DAO {
    @Insert
    suspend fun insertTask(entity: com.example.practica.Entity)

    @Update
    suspend fun updateTask(entity: com.example.practica.Entity)

    @Delete
    suspend fun deleteTask(entity: com.example.practica.Entity)

    @Query("Delete from to_do")
    suspend fun deleteAll()

    @Query("Select * from to_do")
    suspend fun getTasks():List<CardInfo>
}
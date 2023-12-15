package com.example.lab0.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CatDao {

    @Query("SELECT * FROM cat_table")
    fun getAll(): Flow<List<Cat>>

    @Insert
    fun addAll(cat: List<Cat>)
}
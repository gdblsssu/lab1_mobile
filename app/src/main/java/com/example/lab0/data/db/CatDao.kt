package com.example.lab0.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.lab0.data.Cat
import com.example.lab0.utils.Constans.Companion.CAT_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface CatDao {
    @Query("SELECT * FROM cat_table")
    fun getCats(): LiveData<List<Cat>>

    @Insert(onConflict = REPLACE)
    fun addCats(cat: List<Cat>)
}
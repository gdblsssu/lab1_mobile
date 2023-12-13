package com.example.lab0.data.db

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
    @Query("SELECT * FROM $CAT_TABLE")
    fun getCats(): Flow<List<Cat>>
    @Query("SELECT * FROM $CAT_TABLE WHERE id = :id")
    fun getCat(id: Int): Flow<Cat>
    @Insert(onConflict = REPLACE)
    fun addCat(cat: Cat)
    @Insert(onConflict = REPLACE)
    fun addCats(cat: List<Cat>)
    @Update
    fun updateCat(cat: Cat)
    @Delete
    fun deleteCat(cat: Cat)
}
package com.example.lab0.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getCatsFromRoom(): Flow<List<Cat>>
    fun addCatListToRoom(cats: List<Cat>)
}
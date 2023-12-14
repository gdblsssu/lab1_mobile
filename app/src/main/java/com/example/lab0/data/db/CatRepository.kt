package com.example.lab0.data.db

import androidx.lifecycle.LiveData
import com.example.lab0.data.Cat
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CatRepository {
    fun getCatsFromRoom(): LiveData<List<Cat>>
    fun addCatListToRoom(cats: List<Cat>)
}
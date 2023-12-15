package com.example.lab0.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class CatRepositoryImpl(
    private val catDao: CatDao
) : CatRepository {
    override fun getCatsFromRoom() = catDao.getAll()
    override fun addCatListToRoom(cats: List<Cat>) = catDao.addAll(cats)
}
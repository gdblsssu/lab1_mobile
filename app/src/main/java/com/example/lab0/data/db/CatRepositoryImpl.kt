package com.example.lab0.data.db

import androidx.lifecycle.LiveData
import com.example.lab0.data.Cat
import kotlinx.coroutines.flow.Flow

class CatRepositoryImpl(
    private val catDao: CatDao
) : CatRepository {
    override fun getCatsFromRoom(): LiveData<List<Cat>> = catDao.getCats()
    override fun addCatListToRoom(cats: List<Cat>) = catDao.addCats(cats)
}
package com.example.lab0.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cat::class], version = 1)
abstract class CatDb: RoomDatabase() {
    abstract fun catDao(): CatDao

    companion object{
        private var INSTANCE: CatDb? = null
        fun getInstance(context: Context): CatDb{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    CatDb::class.java,
                    "roomdb")
                    .build()
            }

            return INSTANCE as CatDb
        }
    }
}
package com.example.lab0.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lab0.data.Cat

@Database(entities = [Cat::class], version = 1)
abstract class CatDb : RoomDatabase() {
    abstract fun catDao(): CatDao

    companion object{
        @Volatile
        private var instance: CatDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance ?: createDatabase(context)?.also { instance = it }
        }

        private fun createDatabase(context: Context): CatDb{
            return Room.databaseBuilder(
                context.applicationContext,
                CatDb::class.java,
                "cat_db"
            ).build()
        }
    }
}
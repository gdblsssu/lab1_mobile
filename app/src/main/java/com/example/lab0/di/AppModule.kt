package com.example.lab0.di

import android.app.Application
import androidx.room.Room.databaseBuilder
import com.example.lab0.data.CatDao
import com.example.lab0.data.CatDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideDB(application: Application?): CatDb? {
        return databaseBuilder(application!!, CatDb::class.java, "cat_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDataDAO(appDatabase: CatDb): CatDao? {
        return appDatabase.catDao()
    }
}
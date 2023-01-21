package com.example.exteraedgeassignment.di

import android.content.Context
import androidx.room.Room
import com.example.exteraedgeassignment.data.local.database.RocketDatabase
import com.example.exteraedgeassignment.data.local.dao.RocketDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideShellDao(rocketDatabase: RocketDatabase): RocketDAO {
        return  rocketDatabase.rocketDAO()
    }

    @Provides
    @Singleton
    fun provideShellDatabase(@ApplicationContext appContext: Context): RocketDatabase {
        return Room.databaseBuilder(
            appContext,
            RocketDatabase::class.java,
            RocketDatabase.DB_NAME).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

    }





}
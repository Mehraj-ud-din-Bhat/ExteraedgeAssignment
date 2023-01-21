package com.example.exteraedgeassignment.di

import com.example.exteraedgeassignment.data.local.database.RocketDatabase
import com.example.exteraedgeassignment.data.local.repository.Repository
import com.example.exteraedgeassignment.data.remote.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(rocketDatabase: RocketDatabase, apiService: APIService): Repository {
        return Repository(rocketDatabase,apiService)
    }
}
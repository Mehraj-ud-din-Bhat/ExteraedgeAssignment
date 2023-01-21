package com.example.exteraedgeassignment.data.local.repository

import androidx.lifecycle.LiveData
import androidx.room.withTransaction

import com.example.exteraedgeassignment.data.local.database.RocketDatabase
import com.example.exteraedgeassignment.data.local.entity.RocketEntity
import com.example.exteraedgeassignment.data.remote.APIService
import com.example.exteraedgeassignment.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import networkBoundResource


class Repository(val database: RocketDatabase, val apiService: APIService) {
      val dao=database.rocketDAO()

 fun getRockets(): Flow<Resource<List<RocketEntity>>> = networkBoundResource(
        query = {
            dao.getAllRockets()
        },
        fetch = {
            delay(2000)
            apiService.getRockets()
        },
        saveFetchResult = { rockets ->
            database.withTransaction {
                for(r in rockets.body()!!)
                {
                    dao.insertRocket(r.getRocketEntity())
                }
               // dao.insertAll(rockets.body())
            }
        }
    )

}
package com.example.exteraedgeassignment.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exteraedgeassignment.data.local.entity.FlickerImageEntity
import com.example.exteraedgeassignment.data.local.entity.Rocket
import com.example.exteraedgeassignment.data.local.entity.RocketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAll(rockets:List<RocketEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertRocket(rocket:RocketEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertFlickerImages(rocket:List<FlickerImageEntity>)
      @Query("SELECT * FROM Rockets")
      fun  getAllRockets(): Flow<List<Rocket>>

//      fun deleteAllImages()





}
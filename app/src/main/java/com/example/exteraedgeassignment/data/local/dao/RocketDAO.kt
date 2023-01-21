package com.example.exteraedgeassignment.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exteraedgeassignment.data.local.entity.RocketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAll(rockets:List<RocketEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertRocket(rocket:RocketEntity)
    @Query("SELECT * FROM Rockets")
      fun  getAllRockets(): Flow<List<RocketEntity>>

    @Query("SELECT * FROM Rockets where Id=:rocketID")
     fun  getRocket(rocketID:String):LiveData<RocketEntity>



}
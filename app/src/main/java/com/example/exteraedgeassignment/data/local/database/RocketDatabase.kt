package com.example.exteraedgeassignment.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exteraedgeassignment.data.local.dao.RocketDAO
import com.example.exteraedgeassignment.data.local.entity.FlickerImageEntity
import com.example.exteraedgeassignment.data.local.entity.RocketEntity

@Database(entities = [RocketEntity::class,FlickerImageEntity::class], version = 1)
abstract  class RocketDatabase : RoomDatabase() {
    abstract fun rocketDAO(): RocketDAO
    companion object {
        val DB_NAME = "ROCKETS_DB"
    }

}
package com.example.exteraedgeassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FlickerImages")
class FlickerImageEntity {
    lateinit  var RocketID:String
    @PrimaryKey
     var ImageUrl:String=""

}
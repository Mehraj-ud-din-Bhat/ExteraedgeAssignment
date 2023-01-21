package com.example.exteraedgeassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FlickerImages")
class FlickerImageEntity {
   @PrimaryKey(autoGenerate = true)
     var  id:Int = 0
   lateinit  var RocketID:String
   var ImageUrl:String=""

}
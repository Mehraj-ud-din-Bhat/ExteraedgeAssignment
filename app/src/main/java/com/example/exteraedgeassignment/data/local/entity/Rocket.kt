package com.example.exteraedgeassignment.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation





class Rocket : java.io.Serializable{
    @Embedded
    var rocket: RocketEntity? = null
    @Relation(
        parentColumn = "Id",
        entityColumn = "RocketID",
        entity =FlickerImageEntity::class
    )
    var flickerImages: List<FlickerImageEntity>? = null
    fun getRocketThumbnail():String
    {
        if(flickerImages!=null)
        {
            if(flickerImages!!.size>0)
            {
                return flickerImages!!.get(0).ImageUrl
            }
        }
        return  ""
    }
}
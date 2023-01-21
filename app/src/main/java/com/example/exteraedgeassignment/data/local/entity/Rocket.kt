package com.example.exteraedgeassignment.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation





class Rocket {
    @Embedded
    var rocket: RocketEntity? = null
    @Relation(
        parentColumn = "Id",
        entityColumn = "RocketID",
        entity =FlickerImageEntity::class
    )
    var flickerImages: List<FlickerImageEntity>? = null
}
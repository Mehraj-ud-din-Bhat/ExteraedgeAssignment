package com.example.exteraedgeassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rockets")
 class RocketEntity{
    @PrimaryKey
    lateinit var Id: String
    var Name: String?=null
    var Country: String?=null
    var Company: String?=null
    var Type: String?=null
    var EnginesCount: Int?=null
    var ActiveStatus: Boolean?=null
    var CostPerLaunch: Double?=null
    var SuccessRatePercent: Int?=null
    var Description: String?=null
    var WikipediaLink: String?=null
    var HeightInMeter: Double?=null
    var DiameterInMeter: Double?=null
    var flickerImages: String?=null
}




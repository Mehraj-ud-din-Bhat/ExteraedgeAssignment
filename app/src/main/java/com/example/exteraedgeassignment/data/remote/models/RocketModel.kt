package com.example.exteraedgeassignment.data.remote.models

import com.example.exteraedgeassignment.data.local.entity.FlickerImageEntity
import com.example.exteraedgeassignment.data.local.entity.RocketEntity

class RocketModel (
        var id : String?,
        var name : String?,
        var country : String?,
        var type : String?,
        var active :Boolean?,
        var cost_per_launch : Double?,
        var description : String?,
        var diameter : Diameter?,
        var flickr_images: List<String>?,
        var engines : Engines?,
        var company : String?,
        var success_rate_pct : Int?,
        var wikipedia : String?,
        var height : Height?





    ){
     fun getRocketEntity():RocketEntity{
         var model=RocketEntity()
         model.Id=this.id!!
         model.Name=this.name!!
         model.Country=this.country!!
         model.Type=this.type!!
         model.ActiveStatus=this.active!!
         model.CostPerLaunch=this.cost_per_launch!!
         model.Description=this.description!!
         model.DiameterInMeter=this.diameter!!.meters
         model.HeightInMeter=this.height!!.meters
         model.SuccessRatePercent=this.success_rate_pct
         model.WikipediaLink=this.wikipedia
         model.EnginesCount=this.engines!!.number
         model.Company=this.company


         return model

     }

    fun getRocketFlickerImageList():List<FlickerImageEntity>{
        var list=ArrayList<FlickerImageEntity>()

        for(str in this.flickr_images!!)
        {
            var image=FlickerImageEntity();
            image.RocketID=this.id!!
            image.ImageUrl=str
            list.add(image)
        }
        return list
    }
 }



data class Diameter (
    var meters : Double?

)


data class Height (
    var meters : Double?

)
data class Engines (
    var number : Int?,
)
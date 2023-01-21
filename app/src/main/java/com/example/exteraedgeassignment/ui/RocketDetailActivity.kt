package com.example.exteraedgeassignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exteraedgeassignment.data.local.entity.FlickerImageEntity
import com.example.exteraedgeassignment.data.local.entity.Rocket
import com.example.exteraedgeassignment.databinding.ActivityRocketDetailBinding
import com.example.exteraedgeassignment.ui.adapter.ImageAdapter
import com.example.exteraedgeassignment.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class RocketDetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityRocketDetailBinding
    lateinit var rocket:Rocket
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val personJsonString = intent.getStringExtra(ROCKET_JSON_KEY)
         rocket = Utils.getGsonParser().fromJson(personJsonString, Rocket::class.java)
        initViews()

    }

    private fun initViews() {

        binding.rocketName.text="Rocket Name:  "+rocket.rocket!!.Name
        binding.activeStatus.text="Is Active:  "+rocket.rocket!!.ActiveStatus
        binding.cpl.text="Cost Per Launch:  "+rocket.rocket!!.CostPerLaunch
        binding.srp.text="Success Rate Percent:   "+rocket.rocket!!.SuccessRatePercent+"%"
        binding.desc.text="Description: "+rocket.rocket!!.Description
        binding.wiki.text="Wikipedia Link: "+rocket.rocket!!.WikipediaLink
        binding.height.text="Height In Meter: "+rocket.rocket!!.HeightInMeter
        binding.diameter.text="Diameter In Meter: "+rocket.rocket!!.DiameterInMeter
        initAdapter()

    }
    fun initAdapter()
    {
        val adapter=ImageAdapter(rocket.flickerImages as ArrayList<FlickerImageEntity>)
        binding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
         binding.recyclerView.adapter=adapter

    }

    companion object{
        val ROCKET_JSON_KEY="rocket"
    }
}
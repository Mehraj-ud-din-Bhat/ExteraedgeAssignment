package com.example.exteraedgeassignment.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exteraedgeassignment.data.local.entity.Rocket
import com.example.exteraedgeassignment.databinding.ActivityMainBinding
import com.example.exteraedgeassignment.ui.adapter.RocketAdapter
import com.example.exteraedgeassignment.utils.Resource
import com.example.exteraedgeassignment.utils.Utils
import com.example.exteraedgeassignment.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainView : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var  rocketsAdapter:RocketAdapter
    var rocketList=ArrayList<Rocket>()
    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         initAdapter()
        observeViewModel()

    }


    private fun initAdapter() {

        rocketsAdapter= RocketAdapter(rocketList,object:RocketAdapter.IClickListener{
            override fun onRocketClicked(rocket: Rocket) {
                showInDetail(rocket)
            }

        })
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter=rocketsAdapter

    }

    fun showInDetail(rocket: Rocket)
    {

        val json: String = Utils.getGsonParser().toJson(rocket)

        val intent= Intent(this,RocketDetailActivity::class.java)
        intent.putExtra(RocketDetailActivity.ROCKET_JSON_KEY,json)
        startActivity(intent)
    }

    fun observeViewModel()
    {
        mainViewModel.rockets.observe(this){result->
            if(result!=null)
            {
                when (result) {
                    is Resource.Error -> {
                        if (result.data.isNullOrEmpty()) {
                            //
                            binding.progressBar.isVisible = false
                            binding.errorT.isVisible = true
                            binding.errorT.text = result.error?.localizedMessage
                        }
                    }

                    is Resource.Loading -> {
                        if (result.data.isNullOrEmpty()) {
                            binding.progressBar.visibility =View.VISIBLE

                        }
                    }

                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        binding.errorT.isVisible = false
                        this.rocketList.clear()
                        this.rocketList.addAll(result.data as ArrayList<Rocket>)
                        rocketsAdapter.notifyDataSetChanged()
                    }
                }

            }
        }
    }




}
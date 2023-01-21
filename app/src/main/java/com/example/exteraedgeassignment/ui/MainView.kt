package com.example.exteraedgeassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.exteraedgeassignment.R
import com.example.exteraedgeassignment.utils.Resource
import com.example.exteraedgeassignment.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainView : AppCompatActivity() {
    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.rockets.observe(this){result->
           if(result!=null)
           {
               when (result) {
                   is Resource.Error -> {
                       if (result.data.isNullOrEmpty()) {
                         //
                       //progressBar.isVisible = false
                           //errorT.isVisible = true
                           //errorT.text = result.error?.localizedMessage
                       }
                   }

                   is Resource.Loading -> {
                       if (result.data.isNullOrEmpty()) {
                          // progressBar.isVisible = true
                       }
                   }

                   is Resource.Success -> {
                       //progressBar.isVisible = false
                       //errorT.isVisible = false
                   }
               }

           }
        }
    }
}
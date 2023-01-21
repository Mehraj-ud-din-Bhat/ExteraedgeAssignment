package com.example.exteraedgeassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.exteraedgeassignment.data.local.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor( private val repository: Repository)  : ViewModel() {
    val rockets= repository.getRockets().asLiveData()

}
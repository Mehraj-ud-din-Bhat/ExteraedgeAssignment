package com.example.exteraedgeassignment.data.remote

import com.example.exteraedgeassignment.data.remote.models.RocketModel
import retrofit2.Response
import retrofit2.http.GET

interface  APIService {

    @GET("rockets")
    suspend fun getRockets():Response<List<RocketModel>>
}
package com.example.july_19.network

import com.example.july_19.model.Poetry
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/author,title/Shakespeare;Sonnet")
    suspend fun getPoetry() : List<Poetry>
}
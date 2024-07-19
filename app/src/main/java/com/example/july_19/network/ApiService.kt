package com.example.july_19.network

import com.example.july_19.model.Poetry
import retrofit2.http.GET

interface ApiService {

    @GET("/author,title/Shakespeare;Sonnet")
    suspend fun getPoetry() : List<Poetry>
}
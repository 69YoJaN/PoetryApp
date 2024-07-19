package com.example.july_19.repository

import com.example.july_19.network.RetrofitInstance

class Repository {
    private val apiService = RetrofitInstance.apiService

    suspend fun getPoetry() = apiService.getPoetry()
}
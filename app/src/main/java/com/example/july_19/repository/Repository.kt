package com.example.july_19.repository

import com.example.july_19.model.User
import com.example.july_19.model.UserResponse
import com.example.july_19.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class Repository {
    private val apiService = RetrofitInstance.apiService
    private val restAPIDemo = RetrofitInstance.restAPIDemo
    suspend fun getPoetry() = apiService.getPoetry()

    fun createUser(user : User, callback: (UserResponse?) -> Unit) {

        restAPIDemo.postAPi(user).enqueue(object : retrofit2.Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if(response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                callback(null)
            }

        })
    }
}
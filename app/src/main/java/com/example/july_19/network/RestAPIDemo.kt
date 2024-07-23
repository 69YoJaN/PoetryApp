package com.example.july_19.network

import com.example.july_19.model.User
import com.example.july_19.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RestAPIDemo {

    @POST("/api/users")
    fun postAPi(@Body user: User) : Call<UserResponse>

}
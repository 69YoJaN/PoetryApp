package com.example.july_19.model

data class User (
    val job: String,
    val name: String
)

data class UserResponse (
    val name : String,
    val job : String,
    val id : String,
    val createdAt : String
)
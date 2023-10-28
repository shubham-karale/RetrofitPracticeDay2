package com.example.retrofitpracticeday2

data class UserData(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)
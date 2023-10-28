package com.example.retrofitpracticeday2

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("users")

    fun getUserData() : Call<UserData>

}
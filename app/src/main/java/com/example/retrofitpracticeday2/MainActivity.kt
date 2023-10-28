package com.example.retrofitpracticeday2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recylerView : RecyclerView

    lateinit var adapter:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recylerView = findViewById(R.id.recylerView)


        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getUserData()

        retrofitData.enqueue(object : Callback<UserData?> {
            override fun onResponse(call: Call<UserData?>, response: Response<UserData?>) {
               val responseBody = response.body()!!
//                REMEMBER: In userList variables pass direct responseBody.users
                val userList = responseBody.users
                adapter = UserAdapter(this@MainActivity,userList)
                recylerView.adapter = adapter
                recylerView.layoutManager = LinearLayoutManager(this@MainActivity)



            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)

            }

        })





    }
}
package com.appsv.composeproject.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Create a Retrofit instance
val retrofit = Retrofit.Builder()
    .baseUrl("https://cricket.sportmonks.com/api/v2.0/")  // Base URL of the API
    .addConverterFactory(GsonConverterFactory.create())   // Use Gson to parse JSON
    .build()


// Create an instance of the API service
//val apiService = retrofit.create(SportMonksApiService::class.java)

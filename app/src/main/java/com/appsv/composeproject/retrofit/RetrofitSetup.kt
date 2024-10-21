package com.appsv.composeproject.retrofit

import com.appsv.composeproject.cricket.CricketRankings
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query





interface SportMonksApiService {
    @GET("team-rankings")
     fun getTeamRankings(
        @Query("filter[type]") type: String,          // Query param for type (e.g., ODI)
        @Query("filter[gender]") gender: String,      // Query param for gender (e.g., women)
        @Query("api_token") apiToken: String          // Query param for API key
    ): Call<CricketRankings>
}


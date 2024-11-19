package com.appsv.composeproject.pagination_practice.data.remote

import com.appsv.composeproject.pagination_practice.dto.AirlineDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AirlineAPI {

    @GET("v1/passenger")
   suspend fun getAirlineResponse(
        @Query("page") page : Int,
        @Query("size") size : Int,
    ):Response<AirlineDTO>


}
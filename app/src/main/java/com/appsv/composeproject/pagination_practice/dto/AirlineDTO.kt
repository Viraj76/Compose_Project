package com.appsv.composeproject.pagination_practice.dto

data class AirlineDTO(
    val data: List<Data>,
    val totalPages: Int,
    val totalPassengers: Int
)

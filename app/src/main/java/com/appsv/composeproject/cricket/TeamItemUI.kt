package com.appsv.composeproject.cricket

data class TeamItemUI(
    val id: Int,
    val type : String,
    val gender : String,
    val name: String,
    val code: String,
    val image_path: String,
    val ranking: Ranking,
)

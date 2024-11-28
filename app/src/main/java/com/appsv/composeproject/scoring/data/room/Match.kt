package com.appsv.composeproject.scoring.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Match")
data class Match(
    @PrimaryKey(autoGenerate = true) val matchId: Int = 0,
    val team1: String,
    val team2: String,
    val venue: String,
    val date: String
)

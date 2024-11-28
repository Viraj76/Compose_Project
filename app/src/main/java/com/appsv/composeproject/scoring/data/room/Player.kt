package com.appsv.composeproject.scoring.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Player")
data class Player(
    @PrimaryKey(autoGenerate = true) val playerId: Int = 0,
    val playerName: String,
    val teamName: String
)

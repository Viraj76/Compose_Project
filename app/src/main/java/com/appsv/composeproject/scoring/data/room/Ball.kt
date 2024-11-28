package com.appsv.composeproject.scoring.data.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Ball"
)
data class Ball(
    @PrimaryKey(autoGenerate = true) val ballId: Int = 0,
    val matchId: Int,
    val innings: Int,
    val overNumber: Int,
    val ballNumber: Int, // Ball number within the over (e.g., 1 to 6)
    val bowlerId: Int,
    val batsmanId: Int,
    val nonStrikerId: Int,
    val runsScored: Int,
    val extrasType: String?, // "wide", "no-ball", "leg-bye", "bye", null if no extras
    val extrasRuns: Int = 0, // Number of runs scored as extras
    val isWicket: Boolean = false,
    val wicketType: String?, // "bowled", "caught", "run-out", etc.
    val isLastBallOfOver: Boolean = false
)

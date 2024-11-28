package com.appsv.composeproject.scoring.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BallDao {
    // Insert a new ball
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBall(ball: Ball)

    // Get all balls for a specific match and innings
    @Query("SELECT * FROM Ball WHERE matchId = :matchId AND innings = :innings ORDER BY overNumber, ballNumber")
    suspend fun getBallsForMatch(matchId: Int, innings: Int): List<Ball>

    // Get the last ball for the current match and innings
    @Query("SELECT * FROM Ball WHERE matchId = :matchId AND innings = :innings ORDER BY overNumber DESC, ballNumber DESC LIMIT 1")
    suspend fun getLastBall(matchId: Int, innings: Int): Ball?

    // Delete all balls for a match
    @Query("DELETE FROM Ball WHERE matchId = :matchId")
    suspend fun deleteBallsForMatch(matchId: Int)
}

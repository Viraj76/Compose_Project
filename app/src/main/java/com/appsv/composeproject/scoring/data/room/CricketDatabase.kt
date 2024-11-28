package com.appsv.composeproject.scoring.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

@Database(entities = [Match::class, Player::class, Ball::class], version = 2, exportSchema = false)
abstract class CricketDatabase : RoomDatabase() {
    abstract fun ballDao(): BallDao
//    abstract fun matchDao(): MatchDao
//    abstract fun playerDao(): PlayerDao

    companion object {
        @Volatile
        private var INSTANCE: CricketDatabase? = null

        fun getDatabase(context: Context): CricketDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CricketDatabase::class.java,
                    "cricket_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}



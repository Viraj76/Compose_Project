package com.appsv.composeproject.scoring.data.room

import android.content.Context
import java.io.File

object DatabaseUtil {

    /**
     * Retrieves the size of Room database with the name [dbName] in bytes.
     *
     * @param context current android.content.Context
     * @param dbName the database name
     * @return the database size in bytes
     */
    @Throws(Exception::class)
    fun getRoomDatabaseSize(context: Context, dbName: String): Long {
        val dbFolderPath = context.filesDir.absolutePath.replace("files", "databases")
        val dbFile = File("$dbFolderPath/$dbName")

        // Check if database file exist.
        if (!dbFile.exists()) throw Exception("${dbFile.absolutePath} doesn't exist")

        return dbFile.length()
    }
}
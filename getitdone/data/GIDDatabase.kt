package com.example.getitdone.data

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [GetItDone::class], version = 1, exportSchema = false)
abstract class GIDDatabase : RoomDatabase() {
    abstract fun doneDao(): DoneDao

    companion object {
        @Volatile private var INSTANCE: GIDDatabase? = null
        fun getDatabase(context: Context): GIDDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    GIDDatabase::class.java,
                    "GID_Database").build().also {INSTANCE = it}
               }
           }
        }
    }
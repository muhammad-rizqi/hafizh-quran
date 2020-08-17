package com.rizqi.hafizhquran.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rizqi.hafizhquran.model.Aya
import com.rizqi.hafizhquran.model.Indo

@Database(entities = [Aya::class, Indo::class], version = 1, exportSchema = false)

abstract class AyaRoomDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: AyaRoomDatabase? = null

        fun getDatabase(context: Context): AyaRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AyaRoomDatabase::class.java,
                    "quran.db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }

    }

    abstract fun getUserDao(): AyaDao

}
package com.app.mymvcapp.utils.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.mymvcapp.utils.room.dao.MyDao
import com.app.mymvcapp.utils.room.entity.Data

@Database(entities = [Data::class] ,version = 1)
abstract class UserDatabase  : RoomDatabase() {

    abstract fun roomDao() : MyDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): UserDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "user_database"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}
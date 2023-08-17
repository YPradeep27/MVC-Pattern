package com.app.mymvcapp.utils.di.modules

import android.content.Context
import com.app.mymvcapp.utils.room.dao.MyDao
import com.app.mymvcapp.utils.room.database.UserDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context) : UserDatabase {
        return UserDatabase.getDatabase(context)

    }

    @Provides
    fun provideDao(database: UserDatabase) : MyDao{
        return database.roomDao()
    }

}
package com.app.mymvcapp.utils.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.app.mymvcapp.utils.Constants
import com.app.mymvcapp.utils.di.annotations.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class DaggerModule(val context: Context) {

    @Provides
    @ApplicationScope
    fun provideContext () : Context {
        return context
    }

    @Provides
    @ApplicationScope
    fun provideSharedPreference() : SharedPreferences{
        return context.getSharedPreferences(Constants.Shared_Pref,Context.MODE_PRIVATE)
    }
}
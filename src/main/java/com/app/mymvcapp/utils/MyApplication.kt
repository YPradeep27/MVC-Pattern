package com.app.mymvcapp.utils

import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.app.mymvcapp.utils.di.component.DaggerMyComponent
import com.app.mymvcapp.utils.di.component.MyComponent
import com.app.mymvcapp.utils.di.modules.DaggerModule
import com.app.mymvcapp.utils.di.modules.DatabaseModule
import timber.log.Timber

class MyApplication : MultiDexApplication() {

    lateinit var myComponent: MyComponent

    override fun onCreate() {
        super.onCreate()

        myComponent = DaggerMyComponent.builder().daggerModule(
            DaggerModule(
                this
            )
        ).databaseModule(DatabaseModule()).build()


        //---------Timber object build-----------
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

}
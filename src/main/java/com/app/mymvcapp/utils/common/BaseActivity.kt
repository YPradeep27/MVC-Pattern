package com.app.mymvcapp.utils.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.mymvcapp.utils.MyApplication
import com.app.mymvcapp.utils.di.modules.HelperSharedPreference
import com.app.mymvcapp.utils.network.RetrofitInterface
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreference : HelperSharedPreference

    @Inject
    lateinit var retrofit: RetrofitInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).myComponent.inject(this)
    }
}
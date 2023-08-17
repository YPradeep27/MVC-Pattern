package com.app.mymvcapp.utils.di.component

import com.app.mymvcapp.utils.common.BaseActivity
import com.app.mymvcapp.utils.common.BaseFragment
import com.app.mymvcapp.utils.di.annotations.scopes.ApplicationScope
import com.app.mymvcapp.utils.di.modules.DaggerModule
import com.app.mymvcapp.utils.di.modules.DatabaseModule
import com.app.mymvcapp.utils.di.modules.RetrofitModule
import dagger.Component

@ApplicationScope
@Component(modules = [DaggerModule::class,RetrofitModule::class, DatabaseModule::class])
interface MyComponent {

    fun inject(activity: BaseActivity)
    fun inject(fragment: BaseFragment)
}
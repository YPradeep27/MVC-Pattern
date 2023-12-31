package com.app.mymvcapp.utils.di.modules

import com.app.mymvcapp.utils.Constants
import com.app.mymvcapp.utils.di.annotations.scopes.ApplicationScope
import com.app.mymvcapp.utils.network.RetrofitInterface
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule {

    @Provides
    @ApplicationScope
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {

        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Timber.i(it) })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {

        return OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(210, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()


    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(okhttpClient: OkHttpClient): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okhttpClient)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofitService(retrofit: Retrofit): RetrofitInterface
    {
        return retrofit.create(RetrofitInterface::class.java)
    }


}
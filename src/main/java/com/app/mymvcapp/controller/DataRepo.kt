package com.app.mymvcapp.controller

import android.util.Log
import com.app.mymvcapp.DataPOJO
import com.app.mymvcapp.utils.network.RetrofitInterface
import com.app.mymvcapp.utils.room.entity.Data
import javax.inject.Inject

class DataRepo
@Inject
constructor(private val retrofit: RetrofitInterface){

    suspend fun getData(size : Int) : DataPOJO {
        return retrofit.getUsers(size)
    }
}
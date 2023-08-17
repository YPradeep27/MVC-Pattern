package com.app.mymvcapp.utils.network

import com.app.mymvcapp.DataPOJO
import com.app.mymvcapp.utils.room.entity.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/api/users")
    suspend fun getUsers(
        @Query("per_page")size : Int
    ) : DataPOJO


}
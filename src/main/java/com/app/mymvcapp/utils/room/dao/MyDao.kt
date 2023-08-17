package com.app.mymvcapp.utils.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.mymvcapp.utils.room.entity.Data

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(data: Data)

    @Query("SELECT * FROM dataStoreDetails")
    fun getAllUsers() : LiveData<List<Data>>


    @Query("SELECT * FROM dataStoreDetails WHERE id=:Id")
    fun getUsersDetailsById(Id: Int) : LiveData<Data>
}
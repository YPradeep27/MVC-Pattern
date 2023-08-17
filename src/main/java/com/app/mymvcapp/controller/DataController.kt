package com.app.mymvcapp.controller

import com.app.mymvcapp.utils.common.BaseData
import com.app.mymvcapp.utils.coroutine.Coroutines
import timber.log.Timber


class DataController(private val dataRepo: DataRepo, private val baseData: BaseData) {

    fun getData(size : Int){

       Coroutines.main {

           val data = dataRepo.getData(size)
           Timber.e("${data.data.size}")
           if (data.data.isNotEmpty()){
               baseData.showData(data)
           }else{
               baseData.showError()
           }
       }

    }
}
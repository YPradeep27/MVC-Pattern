package com.app.mymvcapp.utils.common

import com.app.mymvcapp.DataPOJO
import com.app.mymvcapp.utils.room.entity.Data

interface BaseData {

    fun showData(data : DataPOJO)
    fun showError()
}
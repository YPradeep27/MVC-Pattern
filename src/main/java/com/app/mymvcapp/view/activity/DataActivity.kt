package com.app.mymvcapp.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mymvcapp.DataPOJO
import com.app.mymvcapp.R
import com.app.mymvcapp.controller.DataController
import com.app.mymvcapp.controller.DataRepo
import com.app.mymvcapp.databinding.ActivityMainBinding
import com.app.mymvcapp.utils.common.BaseActivity
import com.app.mymvcapp.utils.common.BaseData
import com.app.mymvcapp.utils.extensions.isNetworkActive
import com.app.mymvcapp.utils.extensions.toast
import com.app.mymvcapp.utils.room.entity.Data
import com.app.mymvcapp.view.adapters.DataAdapter
import kotlinx.coroutines.DelicateCoroutinesApi
import timber.log.Timber

class DataActivity : BaseActivity(), View.OnClickListener , BaseData {

    lateinit var binding : ActivityMainBinding
    lateinit var dataController: DataController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialization()
        onClickListeners()
        fetchData()

    }

    private fun fetchData() {
        if (this.isNetworkActive()){
            dataController.getData(10)
        }else{
            this.toast("No Internet Connection")
        }

    }

    private fun initialization() {
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        dataController = DataController(DataRepo(retrofit),this)
    }

    private fun onClickListeners() {

        binding.btnGet.setOnClickListener(this@DataActivity)
        binding.btnSave.setOnClickListener(this@DataActivity)

    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.btnGet -> {

                binding.outputField.text = sharedPreference.getString("Data")

            }

            R.id.btnSave -> {
                sharedPreference.saveString("Data",binding.inputField.text.trim().toString())
            }


        }
    }

    override fun showData(data: DataPOJO) {
        binding.recyclerViewUsers.adapter = DataAdapter(data)
    }

    override fun showError() {
        this.toast("Something Went Wrong")
    }
}
package com.app.mymvcapp.utils.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
package com.example.h2bet.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    var openSettings : MutableLiveData<Boolean> = MutableLiveData(false)

    fun changeOpenSettings(){
        openSettings.value = true
        openSettings.value = false
    }
}
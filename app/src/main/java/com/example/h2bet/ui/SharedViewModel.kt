package com.example.h2bet.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.h2bet.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(repo: Repository): ViewModel() {
    var openSettings : MutableLiveData<Boolean> = MutableLiveData(false)

    fun changeOpenSettings(){
        openSettings.value = true
        openSettings.value = false
    }
}
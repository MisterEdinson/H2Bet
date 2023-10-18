package com.example.h2bet.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.h2bet.data.network.models.league.Value
import com.example.h2bet.data.network.models.ligs.ValueItem
import com.example.h2bet.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repo: Repository): ViewModel() {
    var openSettings : MutableLiveData<Boolean> = MutableLiveData(false)
    var allLigData : MutableLiveData<List<ValueItem?>?> = MutableLiveData()
    var selectChamp : MutableLiveData<Value?> = MutableLiveData()

    init {
        getAllLig()
    }

    fun changeOpenSettings(){
        openSettings.value = true
        openSettings.value = false
    }

    fun getAllLig(){
        viewModelScope.launch {
            val response = repo.getAllLig()
            allLigData.value = response
        }
    }

    fun getSelectLig(id:Int){
        viewModelScope.launch {
            val response = repo.getSelectLig(id)
            selectChamp.value = response
        }
    }
}
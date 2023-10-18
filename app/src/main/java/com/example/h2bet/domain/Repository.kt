package com.example.h2bet.domain

import android.util.Log
import com.example.h2bet.data.network.SimpleRetrofit
import com.example.h2bet.data.network.models.ligs.ValueItem
import javax.inject.Inject

class Repository @Inject constructor(private val retro: SimpleRetrofit) {
    suspend fun getAllLig() : List<ValueItem?>?{
        val response = retro.getAllLig().value
        return response
    }

    suspend fun getSelectLig(champId:Int){

    }
}
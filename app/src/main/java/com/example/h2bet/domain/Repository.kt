package com.example.h2bet.domain

import android.util.Log
import com.example.h2bet.data.network.SimpleRetrofit
import com.example.h2bet.data.network.models.league.Value
import com.example.h2bet.data.network.models.ligs.ValueItem
import javax.inject.Inject

class Repository @Inject constructor(private val retro: SimpleRetrofit) {
    suspend fun getAllLig() : List<ValueItem?>?{
        return retro.getAllLig().value
    }

    suspend fun getSelectLig(champId:Int) : Value?{
        return retro.selectLeague(champId).value
    }
}
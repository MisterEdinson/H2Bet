package com.example.h2bet.data.network

import com.example.h2bet.data.network.models.league.LeagueChampionatGeneral
import com.example.h2bet.data.network.models.ligs.GeneralItem
import retrofit2.http.GET

interface SimpleRetrofit {
    @GET("GetChampsZip?sport=1")
    suspend fun getAllLig(): GeneralItem

    @GET("GetChampZip?champ=88637")
    suspend fun selectLeague(): LeagueChampionatGeneral
}
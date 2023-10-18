package com.example.h2bet.data.network

import com.example.h2bet.data.network.models.league.LeagueChampionatGeneral
import com.example.h2bet.data.network.models.ligs.GeneralItem
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleRetrofit {
    @GET("GetChampsZip?sport=1")
    suspend fun getAllLig(): GeneralItem

    @GET("GetChampZip")
    suspend fun selectLeague(
        @Query("champ") champ: Int,
    ): LeagueChampionatGeneral
}
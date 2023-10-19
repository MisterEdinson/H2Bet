package com.example.h2bet.data.network

import com.example.h2bet.data.network.models.league.LeagueChampionatGeneral
import com.example.h2bet.data.network.models.ligs.GeneralItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleRetrofit {
    @GET("dsadasdsavcvcxrew312fds")
    suspend fun getAllLig(): GeneralItem

    @GET("dsadasdsavcvcxrew312fds/{id}")
    suspend fun selectLeague(
        @Path("id") id: Int
    ): LeagueChampionatGeneral
}
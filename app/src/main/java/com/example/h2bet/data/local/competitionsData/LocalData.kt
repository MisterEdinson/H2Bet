package com.example.h2bet.data.local.competitionsData

import com.example.h2bet.data.network.models.league.GItem
import com.example.h2bet.data.network.models.ligs.ValueItem
import kotlin.random.Random

class LocalData {

    var countCompetitions = Random.nextInt(3, 11)
    var countGame = Random.nextInt(1, 5)
    var compData = mutableListOf<ValueItem>()
    var gameData = mutableListOf<GItem>()

    var competitions = listOf(
        "UEFA Champions League",
        "England. League Cup",
        "England. Premier League",
        "UEFA Conference League",
        "UEFA Europa League",
        "England. Championship",
        "England. League One",
        "Germany. Bundesliga",
        "Germany. 2.Bundesliga",
        "Spain. La Liga",
        "Spain. Segunda Division",
        "Italy. Seria A",
        "Italy. Seria B",
    )

    var comands = listOf(
        "Bayern Munich",
        "Borussia Dortmund",
        "Bayer 04",
        "Stuttgart",
        "Benfica",
        "Napoli",
        "Porto",
        "Roma",
        "Torino",
        "Real Madrid",
        "Barcelona",
        "Sevilla",
        "Atletico",
        "Atalanta",
        "Celta",
        "Valencia",
        "Manchester United",
        "Arsenal",
        "Manchester City",
        "Liverpool",
        "Everton",
        "Chelsea",
        "Fulham",
    )

    fun initCompetitions() {
        for (i in 0..countCompetitions) {
            compData.add(
                ValueItem(
                    "",
                    1,
                    1,
                    competitions.random(),
                    "",
                    countGame,
                    "",
                    1,
                    "",
                    1
                )
            )
        }
    }
}
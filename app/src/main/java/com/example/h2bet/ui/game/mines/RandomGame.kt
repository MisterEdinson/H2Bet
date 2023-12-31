package com.example.h2bet.ui.game.mines

import kotlin.random.Random

class RandomGame {

    var randomData = mutableListOf<MinesDataGame.MinesModel>()

    fun dataInit(){
        for (i in 0..MinesDataGame.COUNT){
            randomData.add(
                MinesDataGame.MinesModel(
                    i,
                    false,
                    rand(),
                    Random.nextBoolean()
                )
            )
        }
    }

    private fun rand(): Double{
        return (Random.nextInt(11, 31) / 10.0)
    }

    private fun generateDouble():Float{
        val generate = Random.nextInt(100,200)
        return (generate/100).toFloat()
    }
}
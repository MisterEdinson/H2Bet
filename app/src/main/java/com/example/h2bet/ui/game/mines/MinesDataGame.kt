package com.example.h2bet.ui.game.mines

class MinesDataGame {
    data class MinesModel(
        var id:Int,
        var select: Boolean,
        var value: Float,
        var type: Boolean
    )

    companion object {
        const val COUNT = 27
    }
}
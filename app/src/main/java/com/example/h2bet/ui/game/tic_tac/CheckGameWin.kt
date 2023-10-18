package com.example.h2bet.ui.game.tic_tac

class CheckGameWin(private val data: List<TicTacGameModel>) {
    fun checkWin(usr: Int): Int {
        var winSelect = 0
        if (search(1, usr)) {
            winSelect++
            if(search(2, usr)){
                winSelect++
                if(search(3, usr)){
                    winSelect++
                }
            }else if(search(4, usr)){
                winSelect++
                if(search(7, usr)){
                    winSelect++
                }
            }else if(search(5, usr)){
                winSelect++
                if(search(9, usr)){
                    winSelect++
                }
            }
        } else if (search(5, usr)) {
            winSelect++
            if(search(2, usr)){
                winSelect++
                if(search(8, usr)){
                    winSelect++
                }
            }else if(search(4, usr)){
                winSelect++
                if(search(6, usr)){
                    winSelect++
                }
            }else if(search(3, usr)){
                winSelect++
                if(search(7, usr)){
                    winSelect++
                }
            }else if(search(1, usr)){
                winSelect++
                if(search(9, usr)){
                    winSelect++
                }
            }
        } else if (search(9, usr)) {
            winSelect++
            if(search(7, usr)){
                winSelect++
                if(search(8, usr)){
                    winSelect++
                }
            }else if(search(6, usr)){
                winSelect++
                if(search(3, usr)){
                    winSelect++
                }
            }else if(search(5, usr)){
                winSelect++
                if(search(1, usr)){
                    winSelect++
                }
            }
        }
        return winSelect
    }

    private fun search(search: Int, user:Int): Boolean {
        var win = false
        for (num in data) {
            if (num.id == search && num.type == user) {
                win = true
                break
            }
        }
        return win
    }


}
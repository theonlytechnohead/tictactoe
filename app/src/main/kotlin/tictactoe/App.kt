package tictactoe

import java.lang.Exception

class App {
    val greeting: String
        get() {
            return "Tic Tac Toe!"
        }
}

fun main() {
    println(App().greeting)

    val board = Board()
    var play = true

    while (play) {
        print(board)
        print("${Board.CROSS.character} plays: ")
        try {
            val input = readln().split(" ", ",", ", ")
            val x = input[0].toInt()
            val y = input[1].toInt()
            board.placeCross(x, y)
        } catch (e: Exception) {
            play = false
            continue
        }
        val x = (0..2).random()
        val y = (0..2).random()
        board.placeCircle(x, y)
        println()
    }
}

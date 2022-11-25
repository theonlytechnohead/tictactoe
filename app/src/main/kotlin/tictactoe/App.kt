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
            var invalid = true
            while (invalid) {
                val input = readln().split(" ", ",", ", ")
                val x = input[0].toInt()
                val y = input[1].toInt()
                invalid = !board.placeCross(x, y)
            }
        } catch (e: Exception) {
            play = false
            continue
        }
        if (board.checkWin()) {
            println("${Board.CROSS.character} wins!")
            print(board)
            play = false
            continue
        }
        var invalid = true
        while (invalid) {
            val x = (0..2).random()
            val y = (0..2).random()
            invalid = !board.placeCircle(x, y)
        }
        println()
        if (board.checkWin()) {
            println("${Board.CIRCLE.character} wins!")
            print(board)
            play = false
        }
    }
}

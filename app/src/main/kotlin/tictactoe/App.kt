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
        var invalid = true
        while (invalid) {
            invalid = try {
                val input = readln().split(" ", ",", ", ")
                val x = input[0].toInt()
                val y = input[1].toInt()
                !board.placeCross(x, y)
            } catch (e: Exception) {
                true
            }
        }
        if (board.checkWin()) {
            println("${Board.CROSS.character} wins!")
            print(board)
            play = false
            continue
        }
        invalid = true
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

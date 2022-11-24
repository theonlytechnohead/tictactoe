package tictactoe

val Int.character: String
    get() {
        return when (this) {
            Board.EMPTY -> " "
            Board.CIRCLE -> "O"
            Board.CROSS -> "X"
            else -> this.toString()
        }
    }

class Board {
    companion object {
        const val EMPTY = 0
        const val CIRCLE = 1
        const val CROSS = 2
    }

    private lateinit var board: Array<Array<Int>>

    init {
        clearBoard()
    }

    private fun clearBoard() {
        board = Array (3) {Array(3) { EMPTY }}
    }

    fun placeCircle(row: Int, column: Int) {
        board[row][column] = CIRCLE
    }

    fun placeCross(row: Int, column: Int) {
        board[row][column] = CROSS
    }

    override fun toString(): String {
        var output = ""
        output += "-------------\n"
        output += "| ${board[0][0].character} | ${board[0][1].character} | ${board[0][2].character} |\n"
        output += "-------------\n"
        output += "| ${board[1][0].character} | ${board[1][1].character} | ${board[1][2].character} |\n"
        output += "-------------\n"
        output += "| ${board[2][0].character} | ${board[2][1].character} | ${board[2][2].character} |\n"
        output += "-------------\n"
        return output
    }
}
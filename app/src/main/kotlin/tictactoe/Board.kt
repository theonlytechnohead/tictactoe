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
        board = Array (3) { Array(3) { EMPTY } }
    }

    fun placeCircle(row: Int, column: Int): Boolean {
        if (board[column][row] == EMPTY)
            board[column][row] = CIRCLE
        else
            return false
        return true
    }

    fun placeCross(row: Int, column: Int): Boolean {
        if (board[column][row] == EMPTY)
            board[column][row] = CROSS
        else
            return false
        return true
    }

    fun checkWin(): Boolean {
        return checkColumns() || checkRows() || checkDiagonals()
    }

    private fun checkColumns(): Boolean {
        return checkColumn(0) || checkColumn(1) || checkColumn(2)
    }

    private fun checkColumn(index: Int): Boolean {
        val column = listOf(board[index][0], board[index][1], board[index][2])
        return column.all { it == CROSS } || column.all { it == CIRCLE }
    }

    private fun checkRows(): Boolean {
        return checkRow(0) || checkRow(1) || checkRow(2)
    }

    private fun checkRow(index: Int): Boolean {
        val row = listOf( board[2][index], board[0][index], board[1][index])
        return row.all { it == CROSS } || row.all { it == CIRCLE }
    }

    private fun checkDiagonals(): Boolean {
        return checkAscendingDiagonal() || checkDescendingDiagonal()
    }

    private fun checkAscendingDiagonal(): Boolean {
        val diagonal = listOf(board[0][0], board[1][1], board[2][2])
        return diagonal.all { it == CROSS } || diagonal.all { it == CIRCLE }
    }

    private fun checkDescendingDiagonal(): Boolean {
        val diagonal = listOf(board[0][2], board[1][1], board[2][0])
        return diagonal.all { it == CROSS } || diagonal.all { it == CIRCLE }
    }

    override fun toString(): String {
        return """
          0   1   2
        -------------
        | ${board[0][0].character} | ${board[0][1].character} | ${board[0][2].character} |  0
        -------------
        | ${board[1][0].character} | ${board[1][1].character} | ${board[1][2].character} |  1
        -------------
        | ${board[2][0].character} | ${board[2][1].character} | ${board[2][2].character} |  2
        -------------""".trimIndent() + "\n"
    }
}
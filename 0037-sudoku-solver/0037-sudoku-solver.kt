class Solution {
    fun solveSudoku(board: Array<CharArray>) {
        solve(board)
    }

    private fun solve(board: Array<CharArray>): Boolean {
        for (row in 0..8) {
            for (col in 0..8) {

                if (board[row][col] == '.') {

                    for (num in '1'..'9') {

                        if (isValid(board, row, col, num)) {
                            board[row][col] = num

                            if (solve(board)) {
                                return true
                            }

                            board[row][col] = '.'
                        }
                    }

                    return false
                }
            }
        }

        return true
    }

    private fun isValid(
        board: Array<CharArray>,
        row: Int,
        col: Int,
        num: Char
    ): Boolean {

        for (i in 0..8) {
            if (board[row][i] == num) return false
            if (board[i][col] == num) return false
        }

        val startRow = (row / 3) * 3
        val startCol = (col / 3) * 3

        for (i in startRow until startRow + 3) {
            for (j in startCol until startCol + 3) {
                if (board[i][j] == num) return false
            }
        }

        return true
    }
}
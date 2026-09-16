class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size

        fun dfs(row: Int, col: Int, index: Int): Boolean {
            if (index == word.length) return true

            if (row !in 0 until m || col !in 0 until n) return false
            if (board[row][col] != word[index]) return false

            val temp = board[row][col]
            board[row][col] = '#'

            val found =
                dfs(row + 1, col, index + 1) ||
                dfs(row - 1, col, index + 1) ||
                dfs(row, col + 1, index + 1) ||
                dfs(row, col - 1, index + 1)

            board[row][col] = temp

            return found
        }

        for (row in 0 until m) {
            for (col in 0 until n) {
                if (dfs(row, col, 0)) {
                    return true
                }
            }
        }

        return false
    }
}
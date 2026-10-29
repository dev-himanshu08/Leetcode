class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix[0].size

        var firstRowZero = false
        var firstColZero = false

        for (j in 0 until n) {
            if (matrix[0][j] == 0) firstRowZero = true
        }

        for (i in 0 until m) {
            if (matrix[i][0] == 0) firstColZero = true
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (firstRowZero) {
            for (j in 0 until n) {
                matrix[0][j] = 0
            }
        }

        if (firstColZero) {
            for (i in 0 until m) {
                matrix[i][0] = 0
            }
        }
    }
}
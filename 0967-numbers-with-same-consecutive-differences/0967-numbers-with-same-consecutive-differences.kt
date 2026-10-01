class Solution {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val result = mutableListOf<Int>()

        fun backtrack(num: Int, length: Int) {
            if (length == n) {
                result.add(num)
                return
            }

            val digit = num % 10

            val next1 = digit + k
            if (next1 <= 9) {
                backtrack(num * 10 + next1, length + 1)
            }

            val next2 = digit - k
            if (k != 0 && next2 >= 0) {
                backtrack(num * 10 + next2, length + 1)
            }
        }

        if (n == 1) {
            return IntArray(10) { it }
        }

        for (firstDigit in 1..9) {
            backtrack(firstDigit, 1)
        }

        return result.toIntArray()
    }
}
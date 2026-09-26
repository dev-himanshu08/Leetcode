class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        val total = matchsticks.sum()

        if (total % 4 != 0) return false

        val side = total / 4
        matchsticks.sortDescending()

        val sides = IntArray(4)

        fun backtrack(index: Int): Boolean {
            if (index == matchsticks.size) {
                return sides.all { it == side }
            }

            val stick = matchsticks[index]

            for (i in 0 until 4) {
                if (sides[i] + stick > side) continue

                if (i > 0 && sides[i] == sides[i - 1]) continue

                sides[i] += stick

                if (backtrack(index + 1)) return true

                sides[i] -= stick
            }

            return false
        }

        return backtrack(0)
    }
}
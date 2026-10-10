
class Solution {
    fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {
        val current = IntArray(12)
        var best = IntArray(12)
        var maxScore = 0

        fun backtrack(index: Int, arrowsLeft: Int, score: Int) {
            if (index < 0) {
                if (score > maxScore) {
                    maxScore = score
                    best = current.clone()
                    best[0] += arrowsLeft
                }
                return
            }

            backtrack(index - 1, arrowsLeft, score)

            val needed = aliceArrows[index] + 1

            if (arrowsLeft >= needed) {
                current[index] = needed

                backtrack(
                    index - 1,
                    arrowsLeft - needed,
                    score + index
                )

                current[index] = 0
            }
        }

        backtrack(11, numArrows, 0)

        return best
    }
}

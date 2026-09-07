class Solution {
    fun numMovesStonesII(stones: IntArray): IntArray {
        stones.sort()

        val n = stones.size

        val maxMoves = maxOf(
            stones[n - 2] - stones[0],
            stones[n - 1] - stones[1]
        ) - (n - 2)

        var minMoves = n
        var left = 0

        for (right in stones.indices) {
            while (stones[right] - stones[left] + 1 > n) {
                left++
            }

            val count = right - left + 1

            if (count == n - 1 &&
                stones[right] - stones[left] + 1 == n - 1
            ) {
                minMoves = minOf(minMoves, 2)
            } else {
                minMoves = minOf(minMoves, n - count)
            }
        }

        return intArrayOf(minMoves, maxMoves)
    }
}
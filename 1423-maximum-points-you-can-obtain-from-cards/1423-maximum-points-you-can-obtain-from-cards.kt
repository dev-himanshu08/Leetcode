class Solution {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val n = cardPoints.size
        val windowSize = n - k

        if (windowSize == 0) {
            return cardPoints.sum()
        }

        var totalSum = cardPoints.sum()

        var windowSum = 0
        for (i in 0 until windowSize) {
            windowSum += cardPoints[i]
        }

        var minWindowSum = windowSum

        for (i in windowSize until n) {
            windowSum += cardPoints[i]
            windowSum -= cardPoints[i - windowSize]

            minWindowSum = minOf(minWindowSum, windowSum)
        }

        return totalSum - minWindowSum
    }
}
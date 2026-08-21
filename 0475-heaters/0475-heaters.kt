class Solution {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        heaters.sort()

        var answer = 0

        for (house in houses) {
            val index = binarySearch(heaters, house)

            val rightDistance =
                if (index < heaters.size) {
                    kotlin.math.abs(heaters[index] - house)
                } else {
                    Int.MAX_VALUE
                }

            val leftDistance =
                if (index > 0) {
                    kotlin.math.abs(heaters[index - 1] - house)
                } else {
                    Int.MAX_VALUE
                }

            val closestDistance = minOf(leftDistance, rightDistance)

            answer = maxOf(answer, closestDistance)
        }

        return answer
    }

    private fun binarySearch(heaters: IntArray, house: Int): Int {
        var left = 0
        var right = heaters.size

        while (left < right) {
            val mid = left + (right - left) / 2

            if (heaters[mid] < house) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }
}
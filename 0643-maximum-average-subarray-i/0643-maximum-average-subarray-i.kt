class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var windowSum = 0

        for (i in 0 until k) {
            windowSum += nums[i]
        }

        var maxSum = windowSum

        for (right in k until nums.size) {
            windowSum += nums[right]
            windowSum -= nums[right - k]

            maxSum = maxOf(maxSum, windowSum)
        }

        return maxSum.toDouble() / k
    }
}
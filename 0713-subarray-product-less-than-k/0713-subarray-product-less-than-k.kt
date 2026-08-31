class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0

        var left = 0
        var product = 1
        var count = 0

        for (right in nums.indices) {
            product *= nums[right]

            while (product >= k) {
                product /= nums[left]
                left++
            }

            count += right - left + 1
        }

        return count
    }
}
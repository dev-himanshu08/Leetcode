class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) return 0

        var current = 0
        var result = 0

        for (i in 2 until nums.size) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                current++
                result += current
            } else {
                current = 0
            }
        }

        return result
    }
}
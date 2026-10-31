class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        var i = 0

        while (i < n) {
            val correctIndex = nums[i] - 1

            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                val temp = nums[i]
                nums[i] = nums[correctIndex]
                nums[correctIndex] = temp
            } else {
                i++
            }
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) {
                return i + 1
            }
        }

        return n + 1
    }
}
class Solution {
    private var maxOr = 0
    private var count = 0

    fun countMaxOrSubsets(nums: IntArray): Int {
        for (num in nums) {
            maxOr = maxOr or num
        }

        dfs(nums, 0, 0)

        return count
    }

    private fun dfs(nums: IntArray, index: Int, currentOr: Int) {
        if (index == nums.size) {
            if (currentOr == maxOr) {
                count++
            }
            return
        }

        // Don't choose nums[index]
        dfs(nums, index + 1, currentOr)

        // Choose nums[index]
        dfs(nums, index + 1, currentOr or nums[index])
    }
}
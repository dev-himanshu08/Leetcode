class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxReach = 0

        for (i in nums.indices) {
            if (i > maxReach) return false

            maxReach = maxOf(maxReach, i + nums[i])

            if (maxReach >= nums.lastIndex) return true
        }

        return true
    }
}
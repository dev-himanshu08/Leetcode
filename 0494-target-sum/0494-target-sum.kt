class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val memo = HashMap<Pair<Int, Int>, Int>()

        fun dfs(index: Int, sum: Int): Int {
            if (index == nums.size) {
                return if (sum == target) 1 else 0
            }

            val key = Pair(index, sum)
            if (key in memo) return memo[key]!!

            val add = dfs(index + 1, sum + nums[index])
            val subtract = dfs(index + 1, sum - nums[index])

            memo[key] = add + subtract
            return memo[key]!!
        }

        return dfs(0, 0)
    }
}
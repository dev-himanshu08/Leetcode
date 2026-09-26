class Solution {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()

        fun backtrack(start: Int) {
            if (path.size >= 2) {
                result.add(path.toList())
            }

            val used = HashSet<Int>()

            for (i in start until nums.size) {
                if (used.contains(nums[i])) continue

                if (path.isNotEmpty() && nums[i] < path.last()) continue

                used.add(nums[i])
                path.add(nums[i])

                backtrack(i + 1)

                path.removeAt(path.lastIndex)
            }
        }

        backtrack(0)
        return result
    }
}
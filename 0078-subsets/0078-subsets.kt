class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int) {
            result.add(current.toList())

            for (i in start until nums.size) {
                current.add(nums[i])
                backtrack(i + 1)
                current.removeAt(current.size - 1)
            }
        }

        backtrack(0)
        return result
    }
}


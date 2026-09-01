class Solution {
    fun findLHS(nums: IntArray): Int {
        val freq = HashMap<Int, Int>()

        for (num in nums) {
            freq[num] = (freq[num] ?: 0) + 1
        }

        var maxLength = 0

        for ((num, count) in freq) {
            if (freq.containsKey(num + 1)) {
                maxLength = maxOf(
                    maxLength,
                    count + freq[num + 1]!!
                )
            }
        }

        return maxLength
    }
}
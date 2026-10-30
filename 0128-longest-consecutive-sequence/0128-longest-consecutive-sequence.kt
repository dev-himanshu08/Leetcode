class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var longest = 0

        for (num in set) {
            if (num - 1 !in set) {
                var current = num
                var count = 1

                while (current + 1 in set) {
                    current++
                    count++
                }

                longest = maxOf(longest, count)
            }
        }

        return longest
    }
}
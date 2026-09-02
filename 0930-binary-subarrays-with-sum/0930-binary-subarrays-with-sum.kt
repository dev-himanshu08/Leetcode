class Solution {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        val freq = HashMap<Int, Int>()
        freq[0] = 1

        var sum = 0
        var count = 0

        for (num in nums) {
            sum += num

            count += freq.getOrDefault(sum - goal, 0)

            freq[sum] = freq.getOrDefault(sum, 0) + 1
        }

        return count
    }
}
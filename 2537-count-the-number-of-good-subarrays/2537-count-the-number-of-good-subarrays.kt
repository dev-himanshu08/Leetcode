class Solution {
    fun countGood(nums: IntArray, k: Int): Long {
        val freq = HashMap<Int, Long>()

        var left = 0
        var pairs = 0L
        var result = 0L

        for (right in nums.indices) {
            val value = nums[right]
            val count = freq.getOrDefault(value, 0L)

            pairs += count
            freq[value] = count + 1

            while (pairs >= k.toLong()) {
                result += nums.size - right

                val leftValue = nums[left]
                val leftCount = freq[leftValue]!!

                pairs -= leftCount - 1

                if (leftCount == 1L) {
                    freq.remove(leftValue)
                } else {
                    freq[leftValue] = leftCount - 1
                }

                left++
            }
        }

        return result
    }
}
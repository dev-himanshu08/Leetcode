class Solution {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxDeque = ArrayDeque<Int>()
        val minDeque = ArrayDeque<Int>()

        var left = 0
        var answer = 0

        for (right in nums.indices) {

            while (maxDeque.isNotEmpty() && nums[maxDeque.last()] < nums[right]) {
                maxDeque.removeLast()
            }
            maxDeque.addLast(right)

            while (minDeque.isNotEmpty() && nums[minDeque.last()] > nums[right]) {
                minDeque.removeLast()
            }
            minDeque.addLast(right)

            while (nums[maxDeque.first()] - nums[minDeque.first()] > limit) {
                if (maxDeque.first() == left) {
                    maxDeque.removeFirst()
                }

                if (minDeque.first() == left) {
                    minDeque.removeFirst()
                }

                left++
            }

            answer = maxOf(answer, right - left + 1)
        }

        return answer
    }
}
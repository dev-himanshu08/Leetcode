class Solution {
    fun maxSumTwoNoOverlap(
        nums: IntArray,
        firstLen: Int,
        secondLen: Int
    ): Int {
        return maxOf(
            calculate(nums, firstLen, secondLen),
            calculate(nums, secondLen, firstLen)
        )
    }

    private fun calculate(
        nums: IntArray,
        firstLen: Int,
        secondLen: Int
    ): Int {
        val prefix = IntArray(nums.size + 1)

        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }

        var maxFirst = 0
        var answer = 0

        for (i in firstLen..nums.size - secondLen) {
            val firstSum = prefix[i] - prefix[i - firstLen]
            maxFirst = maxOf(maxFirst, firstSum)

            val secondSum = prefix[i + secondLen] - prefix[i]

            answer = maxOf(answer, maxFirst + secondSum)
        }

        return answer
    }
}
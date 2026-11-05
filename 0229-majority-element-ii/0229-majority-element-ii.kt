class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        var candidate1 = 0
        var candidate2 = 0
        var count1 = 0
        var count2 = 0

        for (num in nums) {
            when {
                num == candidate1 -> count1++
                num == candidate2 -> count2++
                count1 == 0 -> {
                    candidate1 = num
                    count1 = 1
                }
                count2 == 0 -> {
                    candidate2 = num
                    count2 = 1
                }
                else -> {
                    count1--
                    count2--
                }
            }
        }

        count1 = 0
        count2 = 0

        for (num in nums) {
            if (num == candidate1) count1++
            if (num == candidate2) count2++
        }

        val result = mutableListOf<Int>()

        if (count1 > nums.size / 3) result.add(candidate1)
        if (candidate2 != candidate1 && count2 > nums.size / 3) result.add(candidate2)

        return result
    }
}
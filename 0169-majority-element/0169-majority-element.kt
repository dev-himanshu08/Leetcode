class Solution {
    fun majorityElement(nums: IntArray): Int {
        var candidate = 0
        var count = 0

        for (num in nums) {
            if (count == 0) {
                candidate = num
            }

            if (num == candidate) {
                count++
            } else {
                count--
            }
        }

        return candidate
    }
}
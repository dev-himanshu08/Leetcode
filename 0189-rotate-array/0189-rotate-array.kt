class Solution {
    fun rotate(nums: IntArray, k: Int) {

        val n = nums.size
        val steps = k % n

        reverse(nums, 0, n - 1)

        reverse(nums, 0, steps - 1)

        reverse(nums, steps, n - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end

        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp

            left++
            right--
        }
    }
}
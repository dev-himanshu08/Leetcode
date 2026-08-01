class Solution {
    fun sortColors(nums: IntArray): Unit {
        var low = 0
        var mid = 0
        var high = nums.size - 1

        while (mid <= high) {
            when (nums[mid]) {
                0 -> {
                    val temp = nums[low]
                    nums[low] = nums[mid]
                    nums[mid] = temp
                    low++
                    mid++
                }
                1 -> {
                    mid++
                }
                2 -> {
                    val temp = nums[mid]
                    nums[mid] = nums[high]
                    nums[high] = temp
                    high--
                }
            }
        }
    }
}
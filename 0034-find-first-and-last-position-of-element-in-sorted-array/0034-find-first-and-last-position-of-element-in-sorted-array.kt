class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = findFirst(nums, target)
        val last = findLast(nums, target)

        return intArrayOf(first, last)
    }

    private fun findFirst(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var result = -1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) {
                result = mid
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }

    private fun findLast(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var result = -1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) {
                result = mid
                left = mid + 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }
}
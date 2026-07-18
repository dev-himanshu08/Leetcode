class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var k = 1

        for (i in 1 until nums.size) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]
                k++
            }
        }

        return k
    }
}
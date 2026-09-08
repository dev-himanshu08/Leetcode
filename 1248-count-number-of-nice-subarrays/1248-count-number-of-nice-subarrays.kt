class Solution {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        var left = 0
        var oddCount = 0
        var prefixEven = 0
        var result = 0

        for (right in nums.indices) {

            if (nums[right] % 2 != 0) {
                oddCount++
                prefixEven = 0
            }

            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--
                }
                left++
            }

            if (oddCount == k) {
                while (nums[left] % 2 == 0) {
                    prefixEven++
                    left++
                }

                result += prefixEven + 1
            }
        }

        return result
    }
}
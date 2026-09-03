class Solution {
 fun findLength(nums1: IntArray, nums2: IntArray): Int {
    val dp = IntArray(nums2.size + 1)
    var answer = 0

    for (i in nums1.size - 1 downTo 0) {
        val current = IntArray(nums2.size + 1)

        for (j in nums2.size - 1 downTo 0) {
            if (nums1[i] == nums2[j]) {
                current[j] = 1 + dp[j + 1]
                answer = maxOf(answer, current[j])
            }
        }

        for (j in nums2.indices) {
            dp[j] = current[j]
        }
    }

    return answer
    
    }
}
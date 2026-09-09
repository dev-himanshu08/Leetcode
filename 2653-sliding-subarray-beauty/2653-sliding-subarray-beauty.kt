class Solution {
 fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
    val freq = IntArray(51)
    val result = IntArray(nums.size - k + 1)

    for (i in 0 until k) {
        if (nums[i] < 0) {
            freq[-nums[i]]++
        }
    }

    result[0] = findBeauty(freq, x)

    for (i in k until nums.size) {

        
        if (nums[i] < 0) {
            freq[-nums[i]]++
        }

        
        if (nums[i - k] < 0) {
            freq[-nums[i - k]]--
        }

        result[i - k + 1] = findBeauty(freq, x)
    }

    return result
}

fun findBeauty(freq: IntArray, x: Int): Int {
    var count = 0

    for (value in 50 downTo 1) {
        count += freq[value]

        if (count >= x) {
            return -value
        }
    }

    return 0
}
}
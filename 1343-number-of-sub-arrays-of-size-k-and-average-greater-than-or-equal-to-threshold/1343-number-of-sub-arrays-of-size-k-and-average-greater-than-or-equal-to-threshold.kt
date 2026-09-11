class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var sum = 0
        var count = 0

        for (i in 0 until k) {
            sum += arr[i]
        }

        if (sum >= k * threshold) {
            count++
        }

        for (i in k until arr.size) {
            sum += arr[i]
            sum -= arr[i - k]

            if (sum >= k * threshold) {
                count++
            }
        }

        return count
    }
}
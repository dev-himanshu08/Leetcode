class Solution {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var left = 0
        var totalCost = 0
        var maxLength = 0

        for (right in s.indices) {
            totalCost += kotlin.math.abs(s[right] - t[right])

            while (totalCost > maxCost) {
                totalCost -= kotlin.math.abs(s[left] - t[left])
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}
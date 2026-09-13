class Solution {
    fun maxVowels(s: String, k: Int): Int {
        var count = 0
        var maxCount = 0

        for (i in s.indices) {
            if (s[i] in "aeiou") {
                count++
            }

            if (i >= k && s[i - k] in "aeiou") {
                count--
            }

            if (i >= k - 1) {
                maxCount = maxOf(maxCount, count)
            }
        }

        return maxCount
    }
}
class Solution {
    fun longestPalindrome(s: String): Int {
        val count = IntArray(128)

        for (ch in s) {
            count[ch.code]++
        }

        var length = 0
        var hasOdd = false

        for (freq in count) {
            length += (freq / 2) * 2

            if (freq % 2 == 1) {
                hasOdd = true
            }
        }

        if (hasOdd) {
            length++
        }

        return length
    }
}
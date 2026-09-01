class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val count = IntArray(26)

        for (ch in s1) {
            count[ch - 'a']++
        }

        var left = 0

        for (right in s2.indices) {
            count[s2[right] - 'a']--

            if (right - left + 1 > s1.length) {
                count[s2[left] - 'a']++
                left++
            }

            if (right - left + 1 == s1.length &&
                count.all { it == 0 }
            ) {
                return true
            }
        }

        return false
    }
}
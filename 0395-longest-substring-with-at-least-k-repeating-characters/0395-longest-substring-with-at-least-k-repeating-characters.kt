class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        if (s.isEmpty() || s.length < k) return 0

        val freq = IntArray(26)

        for (ch in s) {
            freq[ch - 'a']++
        }

        for (i in s.indices) {
            if (freq[s[i] - 'a'] < k) {
                val left = longestSubstring(s.substring(0, i), k)
                val right = longestSubstring(s.substring(i + 1), k)

                return maxOf(left, right)
            }
        }

        return s.length
    }
}
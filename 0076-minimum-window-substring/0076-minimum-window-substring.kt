class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) return ""

        val need = HashMap<Char, Int>()

        for (ch in t) {
            need[ch] = need.getOrDefault(ch, 0) + 1
        }

        val window = HashMap<Char, Int>()

        var left = 0
        var right = 0

        var formed = 0
        val required = need.size

        var minLength = Int.MAX_VALUE
        var minLeft = 0

        while (right < s.length) {

            val ch = s[right]
            window[ch] = window.getOrDefault(ch, 0) + 1

            if (need.containsKey(ch) &&
                window[ch] == need[ch]
            ) {
                formed++
            }

            while (left <= right && formed == required) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1
                    minLeft = left
                }

                val leftChar = s[left]
                window[leftChar] = window[leftChar]!! - 1

                if (need.containsKey(leftChar) &&
                    window[leftChar]!! < need[leftChar]!!
                ) {
                    formed--
                }

                left++
            }

            right++
        }

        return if (minLength == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(minLeft, minLeft + minLength)
        }
    }
}
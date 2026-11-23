class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        val n = s.length

        for (len in 1..n / 2) {
            if (n % len != 0) continue

            val sub = s.substring(0, len)
            var valid = true

            for (i in len until n step len) {
                if (s.substring(i, i + len) != sub) {
                    valid = false
                    break
                }
            }

            if (valid) return true
        }

        return false
    }
}
class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val current = mutableListOf<String>()

        fun isPalindrome(left: Int, right: Int): Boolean {
            var l = left
            var r = right

            while (l < r) {
                if (s[l] != s[r]) return false
                l++
                r--
            }

            return true
        }

        fun backtrack(start: Int) {
            if (start == s.length) {
                result.add(current.toList())
                return
            }

            for (end in start until s.length) {
                if (isPalindrome(start, end)) {
                    current.add(s.substring(start, end + 1))
                    backtrack(end + 1)
                    current.removeAt(current.lastIndex)
                }
            }
        }

        backtrack(0)
        return result
    }
}
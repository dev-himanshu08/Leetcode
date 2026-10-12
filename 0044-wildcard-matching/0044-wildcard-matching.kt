class Solution {
    fun isMatch(s: String, p: String): Boolean {
        var i = 0
        var j = 0
        var star = -1
        var match = 0

        while (i < s.length) {
            if (j < p.length && (p[j] == s[i] || p[j] == '?')) {
                i++
                j++
            } else if (j < p.length && p[j] == '*') {
                star = j
                match = i
                j++
            } else if (star != -1) {
                j = star + 1
                match++
                i = match
            } else {
                return false
            }
        }

        while (j < p.length && p[j] == '*') {
            j++
        }

        return j == p.length
    }
}
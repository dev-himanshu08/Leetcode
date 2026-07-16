class Solution {
    fun myAtoi(s: String): Int {
        var i = 0
        val n = s.length

    
        while (i < n && s[i] == ' ') {
            i++
        }

       
        var sign = 1
        if (i < n && (s[i] == '+' || s[i] == '-')) {
            if (s[i] == '-') {
                sign = -1
            }
            i++
        }

       
        var result = 0

        while (i < n && s[i].isDigit()) {
            val digit = s[i] - '0'

            if (result > Int.MAX_VALUE / 10 ||
                (result == Int.MAX_VALUE / 10 && digit > 7)
            ) {
                return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }

            result = result * 10 + digit
            i++
        }

        return result * sign
    }
}
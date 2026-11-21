class Solution {
    fun toHex(num: Int): String {
        if (num == 0) return "0"

        val chars = "0123456789abcdef"
        var n = num.toLong() and 0xFFFFFFFFL
        val result = StringBuilder()

        while (n > 0) {
            val digit = (n and 15).toInt()
            result.append(chars[digit])
            n = n shr 4
        }

        return result.reverse().toString()
    }
}
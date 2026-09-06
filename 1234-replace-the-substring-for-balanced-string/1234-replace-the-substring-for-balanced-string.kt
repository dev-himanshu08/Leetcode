class Solution {
    fun balancedString(s: String): Int {
        val n = s.length
        val required = n / 4

        val count = IntArray(4)

        fun index(c: Char): Int {
            return when (c) {
                'Q' -> 0
                'W' -> 1
                'E' -> 2
                else -> 3
            }
        }

        for (c in s) {
            count[index(c)]++
        }

        if (count.all { it == required }) {
            return 0
        }

        var left = 0
        var answer = n

        for (right in s.indices) {
            count[index(s[right])]--

            while (
                count[0] <= required &&
                count[1] <= required &&
                count[2] <= required &&
                count[3] <= required
            ) {
                answer = minOf(answer, right - left + 1)

                count[index(s[left])]++
                left++
            }
        }

        return answer
    }
}
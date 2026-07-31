class Solution {
    fun countAndSay(n: Int): String {
        var result = "1"

        repeat(n - 1) {
            val sb = StringBuilder()
            var count = 1

            for (i in 1 until result.length) {
                if (result[i] == result[i - 1]) {
                    count++
                } else {
                    sb.append(count)
                    sb.append(result[i - 1])
                    count = 1
                }
            }

            sb.append(count)
            sb.append(result.last())

            result = sb.toString()
        }

        return result
    }
}
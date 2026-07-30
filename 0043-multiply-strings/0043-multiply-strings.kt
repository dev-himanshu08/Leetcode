class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"

        val m = num1.length
        val n = num2.length
        val result = IntArray(m + n)

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val sum = mul + result[i + j + 1]

                result[i + j + 1] = sum % 10
                result[i + j] += sum / 10
            }
        }

        val sb = StringBuilder()
        var started = false

        for (digit in result) {
            if (digit != 0) started = true
            if (started) sb.append(digit)
        }

        return sb.toString()
    }
}
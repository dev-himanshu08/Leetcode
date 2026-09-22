class Solution {
    fun isAdditiveNumber(num: String): Boolean {
        val n = num.length

        for (i in 1 until n) {
            if (num[0] == '0' && i > 1) break

            for (j in i + 1 until n) {
                if (num[i] == '0' && j - i > 1) break

                val first = num.substring(0, i).toLongOrNull() ?: continue
                val second = num.substring(i, j).toLongOrNull() ?: continue

                var a = first
                var b = second
                var index = j
                var count = 2

                while (index < n) {
                    val sum = a + b
                    val sumStr = sum.toString()

                    if (!num.startsWith(sumStr, index)) {
                        break
                    }

                    index += sumStr.length
                    a = b
                    b = sum
                    count++
                }

                if (index == n && count >= 3) {
                    return true
                }
            }
        }

        return false
    }
}
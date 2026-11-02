class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) return "0"

        val result = StringBuilder()

        if ((numerator < 0) xor (denominator < 0)) {
            result.append("-")
        }

        val num = kotlin.math.abs(numerator.toLong())
        val den = kotlin.math.abs(denominator.toLong())

        result.append(num / den)

        var remainder = num % den

        if (remainder == 0L) return result.toString()

        result.append(".")

        val map = HashMap<Long, Int>()

        while (remainder != 0L) {
            if (map.containsKey(remainder)) {
                val index = map[remainder]!!
                result.insert(index, "(")
                result.append(")")
                break
            }

            map[remainder] = result.length

            remainder *= 10

            result.append(remainder / den)

            remainder %= den
        }

        return result.toString()
    }
}
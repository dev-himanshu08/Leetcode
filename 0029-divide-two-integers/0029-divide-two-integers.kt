class Solution {
    fun divide(dividend: Int, divisor: Int): Int {

        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        var dvd = kotlin.math.abs(dividend.toLong())
        val dvs = kotlin.math.abs(divisor.toLong())

        var result = 0L

        while (dvd >= dvs) {
            var temp = dvs
            var multiple = 1L

            while (dvd >= (temp shl 1)) {
                temp = temp shl 1
                multiple = multiple shl 1
            }

            dvd -= temp
            result += multiple
        }

      
        return if ((dividend < 0) xor (divisor < 0))
            -result.toInt()
        else
            result.toInt()
    }
}
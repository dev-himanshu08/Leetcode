class Solution {
    fun nthUglyNumber(n: Int): Int {
        val ugly = LongArray(n)
        ugly[0] = 1

        var i2 = 0
        var i3 = 0
        var i5 = 0

        for (i in 1 until n) {
            val next2 = ugly[i2] * 2
            val next3 = ugly[i3] * 3
            val next5 = ugly[i5] * 5

            ugly[i] = minOf(next2, next3, next5)

            if (ugly[i] == next2) i2++
            if (ugly[i] == next3) i3++
            if (ugly[i] == next5) i5++
        }

        return ugly[n - 1].toInt()
    }
}
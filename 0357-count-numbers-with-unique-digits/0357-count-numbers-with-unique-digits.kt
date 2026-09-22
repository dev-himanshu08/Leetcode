class Solution {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        if (n == 0) return 1

        var count = 10
        var current = 9
        var available = 9

        for (digits in 2..minOf(n, 10)) {
            current *= available
            count += current
            available--
        }

        return count
    }
}
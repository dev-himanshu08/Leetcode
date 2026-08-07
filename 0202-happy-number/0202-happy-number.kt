class Solution {
    fun isHappy(n: Int): Boolean {
        var num = n
        val seen = HashSet<Int>()

        while (num != 1 && !seen.contains(num)) {
            seen.add(num)
            num = getSumOfSquares(num)
        }

        return num == 1
    }

    private fun getSumOfSquares(num: Int): Int {
        var n = num
        var sum = 0

        while (n > 0) {
            val digit = n % 10
            sum += digit * digit
            n /= 10
        }

        return sum
    }
}
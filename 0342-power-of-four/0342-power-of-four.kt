class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        if (n <= 0) return false

        var num = n

        while (num % 4 == 0) {
            num /= 4
        }

        return num == 1
    }
}
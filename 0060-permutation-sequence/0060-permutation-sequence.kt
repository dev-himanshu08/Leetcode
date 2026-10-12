class Solution {
    fun getPermutation(n: Int, k: Int): String {
        val nums = (1..n).toMutableList()
        val factorial = IntArray(n + 1)
        factorial[0] = 1

        for (i in 1..n) {
            factorial[i] = factorial[i - 1] * i
        }

        var k = k - 1
        val result = StringBuilder()

        for (i in n - 1 downTo 0) {
            val index = k / factorial[i]
            result.append(nums[index])
            nums.removeAt(index)
            k %= factorial[i]
        }

        return result.toString()
    }
}
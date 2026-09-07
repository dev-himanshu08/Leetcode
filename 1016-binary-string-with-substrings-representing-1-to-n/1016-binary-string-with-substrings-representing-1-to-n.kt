class Solution {
    fun queryString(s: String, n: Int): Boolean {
        for (num in n downTo (n / 2 + 1)) {
            val binary = Integer.toBinaryString(num)

            if (!s.contains(binary)) {
                return false
            }
        }

        return true
    }
}
class Solution {
    fun maxProduct(s: String): Int {
        val n = s.length
        var ans = 0

        for (mask1 in 1 until (1 shl n)) {
            val sub1 = StringBuilder()
            for (i in 0 until n) {
                if ((mask1 and (1 shl i)) != 0) {
                    sub1.append(s[i])
                }
            }

            if (!isPalindrome(sub1.toString())) continue

            for (mask2 in 1 until (1 shl n)) {
                if ((mask1 and mask2) != 0) continue

                val sub2 = StringBuilder()
                for (i in 0 until n) {
                    if ((mask2 and (1 shl i)) != 0) {
                        sub2.append(s[i])
                    }
                }

                if (isPalindrome(sub2.toString())) {
                    ans = maxOf(ans, sub1.length * sub2.length)
                }
            }
        }

        return ans
    }

    private fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            if (s[left] != s[right]) return false
            left++
            right--
        }

        return true
    }
}
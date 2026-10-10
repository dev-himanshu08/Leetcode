class Solution {
    fun distributeCookies(cookies: IntArray, k: Int): Int {
        val childCookies = IntArray(k)
        var result = Int.MAX_VALUE

        fun backtrack(index: Int) {
            if (index == cookies.size) {
                result = minOf(result, childCookies.maxOrNull()!!)
                return
            }

            for (i in 0 until k) {
                childCookies[i] += cookies[index]

                if (childCookies[i] < result) {
                    backtrack(index + 1)
                }

                childCookies[i] -= cookies[index]

                if (childCookies[i] == 0) break
            }
        }

        backtrack(0)
        return result
    }
}
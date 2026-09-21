class Solution {
    fun countArrangement(n: Int): Int {
        val memo = IntArray(1 shl n) { -1 }

        fun dfs(pos: Int, mask: Int): Int {
            if (pos > n) return 1

            if (memo[mask] != -1) return memo[mask]

            var count = 0

            for (num in 1..n) {
                val bit = 1 shl (num - 1)

                if ((mask and bit) == 0 &&
                    (num % pos == 0 || pos % num == 0)
                ) {
                    count += dfs(pos + 1, mask or bit)
                }
            }

            memo[mask] = count
            return count
        }

        return dfs(1, 0)
    }
}
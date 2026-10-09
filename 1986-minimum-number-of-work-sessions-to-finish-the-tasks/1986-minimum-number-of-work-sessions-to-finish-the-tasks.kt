class Solution {
    fun minSessions(tasks: IntArray, sessionTime: Int): Int {
        val n = tasks.size
        val total = 1 shl n

        val dp = Array(total) { intArrayOf(n + 1, 0) }
        dp[0] = intArrayOf(1, 0)

        for (mask in 1 until total) {
            for (i in 0 until n) {
                if ((mask and (1 shl i)) == 0) continue

                val prev = mask xor (1 shl i)
                var sessions = dp[prev][0]
                var used = dp[prev][1]

                if (used + tasks[i] <= sessionTime) {
                    used += tasks[i]
                } else {
                    sessions++
                    used = tasks[i]
                }

                if (sessions < dp[mask][0] ||
                    (sessions == dp[mask][0] && used < dp[mask][1])) {
                    dp[mask][0] = sessions
                    dp[mask][1] = used
                }
            }
        }

        return dp[total - 1][0]
    }
}
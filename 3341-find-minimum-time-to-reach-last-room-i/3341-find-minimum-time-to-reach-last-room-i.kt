class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size

        val dist = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val pq = java.util.PriorityQueue<Triple<Int, Int, Int>>(
            compareBy { it.first }
        )

        dist[0][0] = 0
        pq.offer(Triple(0, 0, 0))

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (pq.isNotEmpty()) {
            val (time, r, c) = pq.poll()

            if (time != dist[r][c]) continue

            if (r == n - 1 && c == m - 1) {
                return time
            }

            for (d in dirs) {
                val nr = r + d[0]
                val nc = c + d[1]

                if (nr in 0 until n && nc in 0 until m) {
                    val nextTime = maxOf(time, moveTime[nr][nc]) + 1

                    if (nextTime < dist[nr][nc]) {
                        dist[nr][nc] = nextTime
                        pq.offer(Triple(nextTime, nr, nc))
                    }
                }
            }
        }

        return -1
    }
}
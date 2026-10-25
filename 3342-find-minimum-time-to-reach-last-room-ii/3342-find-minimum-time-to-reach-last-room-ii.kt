class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size

        val dist = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })

        dist[0][0] = 0
        pq.offer(Triple(0, 0, 0))

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (pq.isNotEmpty()) {
            val (time, x, y) = pq.poll()

            if (time != dist[x][y]) continue

            if (x == n - 1 && y == m - 1) return time

            for (dir in dirs) {
                val nx = x + dir[0]
                val ny = y + dir[1]

                if (nx !in 0 until n || ny !in 0 until m) continue

                val moveCost = if ((x + y) % 2 == 0) 1 else 2
                val nextTime = maxOf(time, moveTime[nx][ny]) + moveCost

                if (nextTime < dist[nx][ny]) {
                    dist[nx][ny] = nextTime
                    pq.offer(Triple(nextTime, nx, ny))
                }
            }
        }

        return -1
    }
}
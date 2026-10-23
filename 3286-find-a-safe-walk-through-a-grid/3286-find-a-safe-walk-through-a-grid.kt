class Solution {
    fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        val dist = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        val pq = java.util.PriorityQueue<Triple<Int, Int, Int>>(
            compareBy { it.first }
        )

        dist[0][0] = grid[0][0]
        pq.offer(Triple(grid[0][0], 0, 0))

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (pq.isNotEmpty()) {
            val (cost, r, c) = pq.poll()

            if (cost != dist[r][c]) continue

            if (r == m - 1 && c == n - 1) {
                return cost < health
            }

            for (d in dirs) {
                val nr = r + d[0]
                val nc = c + d[1]

                if (nr in 0 until m && nc in 0 until n) {
                    val newCost = cost + grid[nr][nc]

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost
                        pq.offer(Triple(newCost, nr, nc))
                    }
                }
            }
        }

        return false
    }
}
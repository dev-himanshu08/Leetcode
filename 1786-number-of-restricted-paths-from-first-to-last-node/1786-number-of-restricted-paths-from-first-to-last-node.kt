class Solution {
    fun countRestrictedPaths(n: Int, edges: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]

            graph[u].add(Pair(v, w))
            graph[v].add(Pair(u, w))
        }

        val dist = LongArray(n + 1) { Long.MAX_VALUE }
        val pq = java.util.PriorityQueue<Pair<Long, Int>>(
            compareBy { it.first }
        )

        dist[n] = 0L
        pq.offer(Pair(0L, n))

        while (pq.isNotEmpty()) {
            val (d, node) = pq.poll()

            if (d > dist[node]) continue

            for ((next, weight) in graph[node]) {
                val newDist = d + weight

                if (newDist < dist[next]) {
                    dist[next] = newDist
                    pq.offer(Pair(newDist, next))
                }
            }
        }

        val dp = IntArray(n + 1)
        dp[n] = 1

        val nodes = (1..n).sortedBy { dist[it] }

        for (node in nodes) {
            for ((next, _) in graph[node]) {
                if (dist[next] > dist[node]) {
                    dp[next] = ((dp[next].toLong() + dp[node]) % mod).toInt()
                }
            }
        }

        return dp[1]
    }
}
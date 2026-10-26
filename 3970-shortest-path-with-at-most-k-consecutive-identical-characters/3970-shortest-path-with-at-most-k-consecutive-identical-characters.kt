class Solution {
    fun shortestPath(n: Int, edges: Array<IntArray>, labels: String, k: Int): Int {
        if (k <= 0) return -1
        if (n == 1) return 0

        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }

        for (edge in edges) {
            graph[edge[0]].add(Pair(edge[1], edge[2]))
        }

        val dist = Array(n) { IntArray(k + 1) { Int.MAX_VALUE } }
        val pq = PriorityQueue<Triple<Int, Int, Int>>(
            compareBy { it.first }
        )

        dist[0][1] = 0
        pq.offer(Triple(0, 0, 1))

        while (pq.isNotEmpty()) {
            val (cost, node, streak) = pq.poll()

            if (cost != dist[node][streak]) continue

            if (node == n - 1) return cost

            for ((next, weight) in graph[node]) {
                val nextStreak =
                    if (labels[node] == labels[next]) streak + 1 else 1

                if (nextStreak > k) continue

                val newCost = cost + weight

                if (newCost < dist[next][nextStreak]) {
                    dist[next][nextStreak] = newCost
                    pq.offer(Triple(newCost, next, nextStreak))
                }
            }
        }

        return -1
    }
}
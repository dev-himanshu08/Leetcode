class Solution {
    fun minTime(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<IntArray>() }

        for (edge in edges) {
            graph[edge[0]].add(intArrayOf(edge[1], edge[2], edge[3]))
        }

        val dist = IntArray(n) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

        dist[0] = 0
        pq.offer(Pair(0, 0))

        while (pq.isNotEmpty()) {
            val (time, node) = pq.poll()

            if (time != dist[node]) continue
            if (node == n - 1) return time

            for (edge in graph[node]) {
                val next = edge[0]
                val start = edge[1]
                val end = edge[2]

                val depart = maxOf(time, start)

                if (depart > end) continue

                val arrival = depart + 1

                if (arrival < dist[next]) {
                    dist[next] = arrival
                    pq.offer(Pair(arrival, next))
                }
            }
        }

        return -1
    }
}
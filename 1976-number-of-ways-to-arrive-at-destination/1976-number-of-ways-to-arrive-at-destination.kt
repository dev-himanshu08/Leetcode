class Solution {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val MOD = 1_000_000_007L
        val graph = Array(n) { mutableListOf<Pair<Int, Long>>() }

        for (road in roads) {
            val u = road[0]
            val v = road[1]
            val time = road[2].toLong()

            graph[u].add(v to time)
            graph[v].add(u to time)
        }

        val dist = LongArray(n) { Long.MAX_VALUE }
        val ways = LongArray(n)
        val pq = java.util.PriorityQueue<Pair<Long, Int>>(
            compareBy { it.first }
        )

        dist[0] = 0L
        ways[0] = 1L
        pq.offer(0L to 0)

        while (pq.isNotEmpty()) {
            val (time, node) = pq.poll()

            if (time > dist[node]) continue

            for ((next, travelTime) in graph[node]) {
                val newTime = time + travelTime

                when {
                    newTime < dist[next] -> {
                        dist[next] = newTime
                        ways[next] = ways[node]
                        pq.offer(newTime to next)
                    }

                    newTime == dist[next] -> {
                        ways[next] = (ways[next] + ways[node]) % MOD
                    }
                }
            }
        }

        return (ways[n - 1] % MOD).toInt()
    }
}
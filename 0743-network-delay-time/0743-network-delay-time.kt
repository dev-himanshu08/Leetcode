class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

        for (time in times) {
            graph[time[0]].add(time[1] to time[2])
        }

        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        dist[k] = 0

        val pq = java.util.PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.offer(k to 0)

        while (pq.isNotEmpty()) {
            val (node, time) = pq.poll()

            if (time > dist[node]) continue

            for ((neighbor, weight) in graph[node]) {
                val newTime = time + weight

                if (newTime < dist[neighbor]) {
                    dist[neighbor] = newTime
                    pq.offer(neighbor to newTime)
                }
            }
        }

        var result = 0

        for (i in 1..n) {
            if (dist[i] == Int.MAX_VALUE) return -1
            result = maxOf(result, dist[i])
        }

        return result
    }
}
class Solution {
    fun maxProbability(
        n: Int,
        edges: Array<IntArray>,
        succProb: DoubleArray,
        start: Int,
        end: Int
    ): Double {
        val graph = Array(n) { mutableListOf<Pair<Int, Double>>() }

        for (i in edges.indices) {
            val a = edges[i][0]
            val b = edges[i][1]
            val prob = succProb[i]

            graph[a].add(b to prob)
            graph[b].add(a to prob)
        }

        val prob = DoubleArray(n)
        prob[start] = 1.0

        val pq = java.util.PriorityQueue<Pair<Int, Double>>(
            compareByDescending { it.second }
        )

        pq.offer(start to 1.0)

        while (pq.isNotEmpty()) {
            val (node, currProb) = pq.poll()

            if (currProb < prob[node]) continue

            if (node == end) return currProb

            for ((next, edgeProb) in graph[node]) {
                val newProb = currProb * edgeProb

                if (newProb > prob[next]) {
                    prob[next] = newProb
                    pq.offer(next to newProb)
                }
            }
        }

        return 0.0
    }
}
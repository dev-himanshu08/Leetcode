class Solution {
    fun minimumCost(
        source: String,
        target: String,
        original: CharArray,
        changed: CharArray,
        cost: IntArray
    ): Long {
        val INF = Long.MAX_VALUE / 4
        val dist = Array(26) { LongArray(26) { INF } }

        for (i in 0 until 26) {
            dist[i][i] = 0L
        }

        for (i in original.indices) {
            val u = original[i] - 'a'
            val v = changed[i] - 'a'
            dist[u][v] = minOf(dist[u][v], cost[i].toLong())
        }

        for (k in 0 until 26) {
            for (i in 0 until 26) {
                for (j in 0 until 26) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = minOf(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        )
                    }
                }
            }
        }

        var answer = 0L

        for (i in source.indices) {
            val from = source[i] - 'a'
            val to = target[i] - 'a'

            if (dist[from][to] == INF) {
                return -1L
            }

            answer += dist[from][to]
        }

        return answer
    }
}
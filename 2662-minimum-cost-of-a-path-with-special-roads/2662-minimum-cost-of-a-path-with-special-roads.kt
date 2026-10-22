class Solution {
    fun minimumCost(
        start: IntArray,
        target: IntArray,
        specialRoads: Array<IntArray>
    ): Int {
        fun manhattan(x1: Int, y1: Int, x2: Int, y2: Int): Int {
            return kotlin.math.abs(x1 - x2) + kotlin.math.abs(y1 - y2)
        }

        val n = specialRoads.size
        val dist = IntArray(n) { Int.MAX_VALUE }
        val pq = java.util.PriorityQueue<Pair<Int, Int>>(
            compareBy { it.first }
        )

        var answer = manhattan(
            start[0], start[1], target[0], target[1]
        )

        for (i in 0 until n) {
            val road = specialRoads[i]
            val cost = manhattan(
                start[0], start[1], road[0], road[1]
            ) + road[4]

            if (cost < dist[i]) {
                dist[i] = cost
                pq.offer(Pair(cost, i))
            }
        }

        while (pq.isNotEmpty()) {
            val (cost, i) = pq.poll()

            if (cost != dist[i]) continue

            val road = specialRoads[i]
            val x = road[2]
            val y = road[3]

            answer = minOf(
                answer,
                cost + manhattan(x, y, target[0], target[1])
            )

            for (j in 0 until n) {
                val nextRoad = specialRoads[j]

                val nextCost = cost +
                    manhattan(x, y, nextRoad[0], nextRoad[1]) +
                    nextRoad[4]

                if (nextCost < dist[j]) {
                    dist[j] = nextCost
                    pq.offer(Pair(nextCost, j))
                }
            }
        }

        return answer
    }
}
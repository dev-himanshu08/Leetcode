class Solution {
    fun calcEquation(
        equations: List<List<String>>,
        values: DoubleArray,
        queries: List<List<String>>
    ): DoubleArray {
        val graph = HashMap<String, MutableList<Pair<String, Double>>>()

        for (i in equations.indices) {
            val a = equations[i][0]
            val b = equations[i][1]
            val value = values[i]

            graph.getOrPut(a) { mutableListOf() }.add(b to value)
            graph.getOrPut(b) { mutableListOf() }.add(a to 1.0 / value)
        }

        fun dfs(
            start: String,
            end: String,
            visited: MutableSet<String>
        ): Double {
            if (start == end) return 1.0

            visited.add(start)

            for ((neighbor, value) in graph[start] ?: emptyList()) {
                if (neighbor !in visited) {
                    val result = dfs(neighbor, end, visited)
                    if (result != -1.0) {
                        return value * result
                    }
                }
            }

            return -1.0
        }

        return DoubleArray(queries.size) { i ->
            val start = queries[i][0]
            val end = queries[i][1]

            if (start !in graph || end !in graph) {
                -1.0
            } else {
                dfs(start, end, mutableSetOf())
            }
        }
    }
}
class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()

        fun dfs(node: Int) {
            path.add(node)

            if (node == graph.size - 1) {
                result.add(path.toList())
            } else {
                for (next in graph[node]) {
                    dfs(next)
                }
            }

            path.removeAt(path.size - 1)
        }

        dfs(0)
        return result
    }
}
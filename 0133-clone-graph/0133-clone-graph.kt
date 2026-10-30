/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    private val visited = HashMap<Node, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        if (visited.containsKey(node)) {
            return visited[node]
        }

        val clone = Node(node.`val`)
        visited[node] = clone

        for (neighbor in node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor)!!)
        }

        return clone
    }
}
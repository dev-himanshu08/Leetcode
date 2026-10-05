/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun smallestFromLeaf(root: TreeNode?): String {
        var answer: String? = null

        fun dfs(node: TreeNode?, path: String) {
            if (node == null) return

            val current = ('a'.code + node.`val`).toChar() + path

            if (node.left == null && node.right == null) {
                if (answer == null || current < answer!!) {
                    answer = current
                }
                return
            }

            dfs(node.left, current)
            dfs(node.right, current)
        }

        dfs(root, "")

        return answer ?: ""
    }
}
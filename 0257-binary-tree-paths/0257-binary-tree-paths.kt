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
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()

        fun dfs(node: TreeNode?, path: String) {
            if (node == null) return

            val currentPath = if (path.isEmpty()) {
                "${node.`val`}"
            } else {
                "$path->${node.`val`}"
            }

            if (node.left == null && node.right == null) {
                result.add(currentPath)
                return
            }

            dfs(node.left, currentPath)
            dfs(node.right, currentPath)
        }

        dfs(root, "")
        return result
    }
}
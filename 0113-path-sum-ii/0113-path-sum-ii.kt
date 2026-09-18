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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()

        fun dfs(node: TreeNode?, sum: Int) {
            if (node == null) return

            path.add(node.`val`)

            val remaining = sum - node.`val`

            if (node.left == null && node.right == null && remaining == 0) {
                result.add(path.toList())
            }

            dfs(node.left, remaining)
            dfs(node.right, remaining)

            path.removeAt(path.size - 1)
        }

        dfs(root, targetSum)

        return result
    }
}
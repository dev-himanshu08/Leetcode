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
    fun generateTrees(n: Int): List<TreeNode?> {
        return generate(1, n)
    }

    private fun generate(start: Int, end: Int): List<TreeNode?> {
        if (start > end) {
            return listOf(null)
        }

        val result = mutableListOf<TreeNode?>()

        for (rootValue in start..end) {
            val leftTrees = generate(start, rootValue - 1)
            val rightTrees = generate(rootValue + 1, end)

            for (left in leftTrees) {
                for (right in rightTrees) {
                    val root = TreeNode(rootValue)
                    root.left = left
                    root.right = right
                    result.add(root)
                }
            }
        }

        return result
    }
}
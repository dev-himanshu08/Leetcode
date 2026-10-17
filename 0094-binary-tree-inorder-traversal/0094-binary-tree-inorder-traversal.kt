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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        fun inorder(node: TreeNode?) {
            if (node == null) return

            inorder(node.left)
            result.add(node.`val`)
            inorder(node.right)
        }

        inorder(root)
        return result
    }
}
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
    fun recoverTree(root: TreeNode?) {
        var first: TreeNode? = null
        var second: TreeNode? = null
        var prev: TreeNode? = null

        fun inorder(node: TreeNode?) {
            if (node == null) return

            inorder(node.left)

            if (prev != null && prev!!.`val` > node.`val`) {
                if (first == null) {
                    first = prev
                }
                second = node
            }

            prev = node

            inorder(node.right)
        }

        inorder(root)

        if (first != null && second != null) {
            val temp = first!!.`val`
            first!!.`val` = second!!.`val`
            second!!.`val` = temp
        }
    }
}
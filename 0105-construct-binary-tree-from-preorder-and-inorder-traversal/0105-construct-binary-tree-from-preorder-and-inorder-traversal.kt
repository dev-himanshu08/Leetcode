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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = HashMap<Int, Int>()

        for (i in inorder.indices) {
            map[inorder[i]] = i
        }

        var preIndex = 0

        fun build(left: Int, right: Int): TreeNode? {
            if (left > right) return null

            val rootValue = preorder[preIndex++]
            val root = TreeNode(rootValue)

            val mid = map[rootValue]!!

            root.left = build(left, mid - 1)
            root.right = build(mid + 1, right)

            return root
        }

        return build(0, inorder.size - 1)
    }
}
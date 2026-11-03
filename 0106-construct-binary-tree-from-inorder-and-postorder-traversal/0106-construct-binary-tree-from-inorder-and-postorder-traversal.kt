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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val map = HashMap<Int, Int>()

        for (i in inorder.indices) {
            map[inorder[i]] = i
        }

        var postIndex = postorder.size - 1

        fun build(left: Int, right: Int): TreeNode? {
            if (left > right) return null

            val rootValue = postorder[postIndex--]
            val root = TreeNode(rootValue)

            val mid = map[rootValue]!!

            root.right = build(mid + 1, right)
            root.left = build(left, mid - 1)

            return root
        }

        return build(0, inorder.size - 1)
    }
}
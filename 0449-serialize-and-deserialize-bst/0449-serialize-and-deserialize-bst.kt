/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {

    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val result = StringBuilder()

        fun preorder(node: TreeNode?) {
            if (node == null) return

            if (result.isNotEmpty()) result.append(",")
            result.append(node.`val`)

            preorder(node.left)
            preorder(node.right)
        }

        preorder(root)

        return result.toString()
    }

    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null

        val values = data.split(",").map { it.toInt() }
        var index = 0

        fun build(min: Long, max: Long): TreeNode? {
            if (index >= values.size) return null

            val value = values[index].toLong()

            if (value < min || value > max) return null

            index++

            val node = TreeNode(value.toInt())

            node.left = build(min, value - 1)
            node.right = build(value + 1, max)

            return node
        }

        return build(Long.MIN_VALUE, Long.MAX_VALUE)
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * val ser = Codec()
 * val deser = Codec()
 * val tree: String = ser.serialize(root)
 * val ans = deser.deserialize(tree)
 * return ans
 */
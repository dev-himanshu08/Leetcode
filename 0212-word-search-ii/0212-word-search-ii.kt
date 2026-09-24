class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val root = TrieNode()

        for (word in words) {
            var node = root
            for (ch in word) {
                node.children.putIfAbsent(ch, TrieNode())
                node = node.children[ch]!!
            }
            node.word = word
        }

        val m = board.size
        val n = board[0].size

        fun dfs(r: Int, c: Int, node: TrieNode) {
            if (r !in 0 until m || c !in 0 until n) return

            val ch = board[r][c]
            if (ch == '#' || node.children[ch] == null) return

            val next = node.children[ch]!!

            if (next.word != null) {
                result.add(next.word!!)
                next.word = null
            }

            board[r][c] = '#'

            dfs(r + 1, c, next)
            dfs(r - 1, c, next)
            dfs(r, c + 1, next)
            dfs(r, c - 1, next)

            board[r][c] = ch
        }

        for (r in 0 until m) {
            for (c in 0 until n) {
                dfs(r, c, root)
            }
        }

        return result
    }

    class TrieNode {
        val children = HashMap<Char, TrieNode>()
        var word: String? = null
    }
}
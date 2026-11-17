class WordDictionary {

    class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var isEnd = false
    }

    private val root = TrieNode()

    fun addWord(word: String) {
        var node = root

        for (ch in word) {
            val index = ch - 'a'

            if (node.children[index] == null) {
                node.children[index] = TrieNode()
            }

            node = node.children[index]!!
        }

        node.isEnd = true
    }

    fun search(word: String): Boolean {
        return dfs(root, word, 0)
    }

    private fun dfs(node: TrieNode, word: String, index: Int): Boolean {
        if (index == word.length) {
            return node.isEnd
        }

        val ch = word[index]

        if (ch == '.') {
            for (child in node.children) {
                if (child != null && dfs(child, word, index + 1)) {
                    return true
                }
            }
            return false
        }

        val child = node.children[ch - 'a'] ?: return false

        return dfs(child, word, index + 1)
    }
}
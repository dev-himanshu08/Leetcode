class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var isEnd = false
}

class Trie() {

    private val root = TrieNode()

    fun insert(word: String) {
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
        var node = root

        for (ch in word) {
            val index = ch - 'a'

            if (node.children[index] == null) {
                return false
            }

            node = node.children[index]!!
        }

        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var node = root

        for (ch in prefix) {
            val index = ch - 'a'

            if (node.children[index] == null) {
                return false
            }

            node = node.children[index]!!
        }

        return true
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
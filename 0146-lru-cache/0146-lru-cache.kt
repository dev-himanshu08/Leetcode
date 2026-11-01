class LRUCache(private val capacity: Int) {

    class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    private val map = HashMap<Int, Node>()

    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    private fun remove(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun insert(node: Node) {
        val last = tail.prev!!

        last.next = node
        node.prev = last
        node.next = tail
        tail.prev = node
    }

    private fun moveToRecent(node: Node) {
        remove(node)
        insert(node)
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1

        moveToRecent(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node = map[key]!!
            node.value = value
            moveToRecent(node)
            return
        }

        if (map.size == capacity) {
            val lru = head.next!!
            remove(lru)
            map.remove(lru.key)
        }

        val node = Node(key, value)
        map[key] = node
        insert(node)
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
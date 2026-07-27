/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>(compareBy { it.`val` })

        for (node in lists) {
            if (node != null) {
                pq.offer(node)
            }
        }

        val dummy = ListNode(0)
        var current = dummy

        while (pq.isNotEmpty()) {
            val node = pq.poll()

            current.next = node
            current = current.next

            if (node.next != null) {
                pq.offer(node.next)
            }
        }

        return dummy.next
    }
}
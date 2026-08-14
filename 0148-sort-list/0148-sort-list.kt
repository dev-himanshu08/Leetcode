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
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var slow = head
        var fast = head.next

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        val second = slow?.next
        slow?.next = null

        val left = sortList(head)
        val right = sortList(second)

        return merge(left, right)
    }

    private fun merge(
        list1: ListNode?,
        list2: ListNode?
    ): ListNode? {

        val dummy = ListNode(0)
        var current = dummy

        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                current.next = l1
                l1 = l1.next
            } else {
                current.next = l2
                l2 = l2.next
            }

            current = current.next!!
        }

        current.next = l1 ?: l2

        return dummy.next
    }
}
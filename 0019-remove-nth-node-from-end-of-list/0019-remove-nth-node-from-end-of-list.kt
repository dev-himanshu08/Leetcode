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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var fast: ListNode? = dummy
        var slow: ListNode? = dummy

        for (i in 0..n) {
            fast = fast?.next
        }

        while (fast != null) {
            fast = fast.next
            slow = slow?.next
        }

        slow?.next = slow?.next?.next

        return dummy.next
    }
}
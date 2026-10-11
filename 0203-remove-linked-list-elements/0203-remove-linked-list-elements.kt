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
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var curr = dummy

        while (curr.next != null) {
            if (curr.next!!.`val` == `val`) {
                curr.next = curr.next!!.next
            } else {
                curr = curr.next!!
            }
        }

        return dummy.next
    }
}
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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var prev = dummy
        var current = head

        while (current != null) {

            if (current.next != null && current.`val` == current.next!!.`val`) {

                val duplicateValue = current.`val`

                while (current != null && current.`val` == duplicateValue) {
                    current = current.next
                }

                prev.next = current

            } else {
                prev = current
                current = current.next
            }
        }

        return dummy.next
    }
}
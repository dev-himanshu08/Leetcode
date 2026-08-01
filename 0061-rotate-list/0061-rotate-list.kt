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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || head.next == null || k == 0) return head

        var length = 1
        var tail = head

        while (tail?.next != null) {
            tail = tail.next
            length++
        }

        val rotations = k % length
        if (rotations == 0) return head

        tail?.next = head

        var steps = length - rotations
        var newTail = tail

        while (steps-- > 0) {
            newTail = newTail?.next
        }

        val newHead = newTail?.next
        newTail?.next = null

        return newHead
    }
}
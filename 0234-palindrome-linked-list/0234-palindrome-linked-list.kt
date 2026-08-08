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
    fun isPalindrome(head: ListNode?): Boolean {
        val values = mutableListOf<Int>()

        var current = head

        while (current != null) {
            values.add(current.`val`)
            current = current.next
        }

        var left = 0
        var right = values.size - 1

        while (left < right) {
            if (values[left] != values[right]) {
                return false
            }

            left++
            right--
        }

        return true
    }
}
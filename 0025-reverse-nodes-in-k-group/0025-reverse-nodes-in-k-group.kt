class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var groupPrev = dummy

        while (true) {
            var kth: ListNode? = groupPrev

            for (i in 0 until k) {
                kth = kth?.next

                if (kth == null) {
                    return dummy.next
                }
            }

            val groupNext = kth!!.next

            var prev = groupNext
            var current = groupPrev.next

            while (current != groupNext) {
                val temp = current?.next
                current?.next = prev
                prev = current
                current = temp
            }

            val temp = groupPrev.next
            groupPrev.next = kth
            groupPrev = temp!!
        }
    }
}
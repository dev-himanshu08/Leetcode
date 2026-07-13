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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val temp =ListNode(0)
        var l3 = temp
        var l1 = list1
        var l2 = list2
        while(l1!=null && l2!=null){
            if(l1.`val` <= l2.`val`){
                l3.next = l1
                l1 = l1.next
            }else{
                l3.next = l2
                l2 = l2.next
            }
            l3 = l3.next!!
        }
        l3.next = l1?:l2
        return temp.next
    }
}
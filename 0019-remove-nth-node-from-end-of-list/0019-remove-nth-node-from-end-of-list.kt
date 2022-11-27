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
        var cur: ListNode?
        var cnt: Int = 1
        cur = head
        while (cur?.next != null) {
            cnt += 1
            cur = cur.next
        }

        val targetIdx: Int = cnt - n
        cur = head
        if (targetIdx == 0) {
            cur = head?.next
            return cur
        }
        
        var idx: Int = 0
        while (cur?.next != null) {
            if (idx == targetIdx - 1) {
                cur.next = cur?.next?.next
                break
            }
            cur = cur.next
            idx += 1    
        }
        return head
    }
}
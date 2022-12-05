/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode originHead;
    private boolean first = false;
    
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) { 
            return head;
        }
        
        ListNode cur = head, nextNode = null, prevNode = null;

        while (cur != null && cur.next != null) {
            nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = cur;

            if (cur == head) {
                head = nextNode;
            } else {
                prevNode.next = nextNode;
            }
            
            prevNode = cur;
            cur = cur.next;
        }
        return head;
    }
    

}
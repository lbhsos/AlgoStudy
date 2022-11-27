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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = null;
        
        // 1. node 갯수 얻기
        int cnt = 1;
        cur = head;
        while (cur.next != null) {
            cnt += 1;
            cur = cur.next;
        }

        int targetIdx = cnt - n;
        
        if (targetIdx == 0) {
            head = head.next;
            return head;
        }
        
        int idx = 0;
        cur = head;
        while (cur.next != null) {
            if (idx == targetIdx - 1) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            idx += 1;         
        }
        return head;
    }
}
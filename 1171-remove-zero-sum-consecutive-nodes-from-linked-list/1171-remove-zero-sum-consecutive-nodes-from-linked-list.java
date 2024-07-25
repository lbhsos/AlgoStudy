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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode initial = new ListNode(0, head);
        ListNode start = initial;

        while (start != null) {
            int prefixSum = 0;
            ListNode end = start.next;
            while (end != null) {
                prefixSum += end.val;
                if (prefixSum == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }
            start = start.next;
        }
        return initial.next;
    }
}
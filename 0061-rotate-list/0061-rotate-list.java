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
    public int getNodeLength(ListNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return getNodeLength(node.next, depth+1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode answer = null;
        int n = getNodeLength(head, 0);
        if (n == 0) {
            return answer;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }

        int idx = 0;
        ListNode curNode = head;
        ListNode tmp = null;
        
        while (true) {
            if (idx == (n-k-1)) {
                tmp = curNode.next;
                curNode.next = null;                
                break;
            }
            idx++; 
            curNode = curNode.next;
        }

        ListNode start = tmp;
        while (true) {
            if (tmp.next == null) {
                tmp.next = new ListNode(head.val, head.next);
                break;
            }
            tmp = tmp.next;
        }
        answer = new ListNode(start.val, start.next);

        return answer;
    }
}

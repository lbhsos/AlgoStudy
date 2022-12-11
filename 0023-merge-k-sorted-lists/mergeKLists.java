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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode p1, ListNode p2) {
            return p1.val >= p2.val ? 1 : -1;
            }
        });
        for (ListNode node : lists) {
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }

        ListNode head = null;
        ListNode cur = null;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            if (cur == null) {
                cur = tmp;
                head = cur;
            } else {
                cur.next = new ListNode(tmp.val);
                cur = cur.next;
            }
        }
        return head;
    }
}

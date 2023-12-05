/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> visited = new HashMap<>();
        ListNode cur = head;
        while (true) {
            if (cur == null) {
                break;
            }

            if (visited.containsKey(cur)) {
                return true;
            }
            visited.put(cur, Boolean.TRUE);
            cur = cur.next;
        }
        return false;
    }
}

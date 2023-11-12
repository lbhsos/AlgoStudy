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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newNode = null;
        if (head == null) {
            return null;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode pointer = head;
        ListNode answer = null;
        while (true) {
            if (!map.containsKey(pointer.val)) {
                map.put(pointer.val, Boolean.TRUE);
                if (newNode == null) {
                    newNode =  new ListNode(pointer.val);
                    answer = newNode;
                } else {
                    newNode.next = new ListNode(pointer.val);
                    newNode = newNode.next;
                }
            }

            if (pointer.next == null) {
                break;
            }
            pointer = pointer.next;
        }

        return answer;
    }
}

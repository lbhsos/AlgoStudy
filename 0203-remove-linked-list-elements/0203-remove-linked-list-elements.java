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
  public ListNode removeElements(ListNode head, int val) {
    var dummyHead = new ListNode(0, head);

    for (var p = dummyHead; p != null; p = p.next)
      while (p.next != null && p.next.val == val)
        p.next = p.next.next;

    return dummyHead.next;
  }
}

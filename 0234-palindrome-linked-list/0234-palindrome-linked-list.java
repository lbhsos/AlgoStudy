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
    public boolean isPalindrome(ListNode head) {
        if(head == null && head.next == null){
            return true;
        }

        ListNode mid = head;
        ListNode last = head;
        while (last != null && last.next != null) {
            mid = mid.next;
            last = last.next.next;
        }

        ListNode prev = null;
        ListNode current = mid;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        mid.next = null;
        ListNode left = head;
        ListNode right = prev;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
            System.out.println("left: "+ left+" right: "+right);
        }
        return true;
    }
}

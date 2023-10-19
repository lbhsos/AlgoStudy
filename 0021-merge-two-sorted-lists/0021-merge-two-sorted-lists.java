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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pt1 = list1;
        ListNode pt2 = list2;
        ListNode ans = null;
        
        if (pt1 == null && pt2 == null) {
            return ans;
        }

        if (pt1 == null) {
            ans = new ListNode(pt2.val);
            pt2 = pt2.next;
        } else if (pt2 == null) {
            ans = new ListNode(pt1.val);
            pt1 = pt1.next;
        } else if (pt1.val > pt2.val) {
            ans = new ListNode(pt2.val);
            pt2 = pt2.next;
        } else if (pt2.val >= pt1.val) {
            ans = new ListNode(pt1.val);
            pt1 = pt1.next;
        }
        
        ListNode answer = ans;
        
        while (pt1 != null && pt2 != null) {
            if (pt1.val > pt2.val) {
                ans.next = new ListNode(pt2.val);
                pt2 = pt2.next;
            } else {
                ans.next = new ListNode(pt1.val);
                pt1 = pt1.next;
            }
            ans = ans.next;
        }

        if (pt1 == null) {
            while (pt2 != null) {
                ans.next = new ListNode(pt2.val);
                ans = ans.next;
                pt2 = pt2.next;
            }
        } else if (pt2 == null) {
            while (pt1 != null) {
                ans.next = new ListNode(pt1.val);
                ans = ans.next;
                pt1 = pt1.next;
            }
        }

        return answer;
    }
}

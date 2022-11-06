import java.util.Stack;
import java.lang.Math;
import java.math.BigInteger;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        
        pushToStack(l1, firstStack);
        pushToStack(l2, secondStack);
        
        BigInteger firstNum = getNumberFromStack(firstStack);        
        BigInteger secondNum = getNumberFromStack(secondStack);
        return makeNode(firstNum.add(secondNum));
    }
    
    public void pushToStack(ListNode ln, Stack<Integer> stack) {
         while (ln != null) {
            stack.push(ln.val);
            ln = ln.next;
        }
    }
    
    public BigInteger getNumberFromStack(Stack<Integer> stack) {
        int position = stack.size();
        BigInteger ret = new BigInteger("0");
        BigInteger bi = new BigInteger("10");
        
        while (position >= 1) {
            BigInteger stackNum = new BigInteger(String.valueOf(stack.pop()));
            BigInteger popNum = bi.pow(position - 1).multiply(stackNum);
            position--;
            ret = ret.add(popNum);
        }

        return ret;
    }
    
    public ListNode makeNode(BigInteger num) {
        String numAsText = num.toString();
        int length = numAsText.length();
        
        ListNode head = new ListNode(0);
        ListNode last = head;
        ListNode ln;
        for (int position = length - 1; position > -1; position--) {
            int tmp = Character.getNumericValue(numAsText.charAt(position));
            ln = new ListNode(tmp);
            last.next = ln;
            last = last.next;
        }
        return head.next;
    }
}
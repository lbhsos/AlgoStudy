import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
  public String reverseParentheses(String s) {
    char rightBracket = ')';
    char leftBracket = '(';
    Stack<Character> leftStack = new Stack<>();
    Stack<Character> rightStack = new Stack<>();
    boolean metRight = false;
    boolean metLeft = false;
    int n = s.length();
    int i = 0;
    StringBuilder prevSb = new StringBuilder();
    do {
      char currentChar = s.charAt(i);
      if (currentChar == leftBracket) {
        metLeft = true;
      }
      if (!metLeft) {
        prevSb.append(currentChar);
      }
      if (currentChar != rightBracket) {
        if (metRight) {
          rightStack.push(currentChar);
        } else {
          leftStack.push(currentChar);
        }
      } else {
        metRight = true;
        List<Character> tmp = new ArrayList<>();
        while (!rightStack.empty()) {
          tmp.add(rightStack.pop());
        }
        for (Character ch : tmp) {
          rightStack.push(ch);
        }

        while (!leftStack.empty()) {
          Character leftChar = leftStack.pop();
          if (leftChar == leftBracket) {
            break;
          }
          rightStack.push(leftChar);
        }
      }
      i++;
    } while (i != n);

    StringBuilder sb = new StringBuilder();
    while (!rightStack.empty()) {
      sb.append(rightStack.pop());
    }
    return prevSb.toString() + sb.reverse().toString();
  }
}
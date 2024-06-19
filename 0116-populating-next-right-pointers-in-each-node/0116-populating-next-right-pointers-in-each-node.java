/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public Node connect(Node root) {
    Queue<Node> queue = new LinkedList<>();
    if (root == null) {
        return root;
    }
    queue.offer(root);
    int level = 1;
    int pollCount = 0;
    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      pollCount++;
      if (currentNode.left == null) {
        return root;
      }
      currentNode.left.next = currentNode.right;
      if (Math.pow(2, level) - 1 != pollCount) {
        currentNode.right.next = queue.peek().left;
      } else {
        // 맨 마지막 노드 
        level++;
      }
      if (currentNode.left.left == null) {
        continue;
      }
      queue.offer(currentNode.left);
      queue.offer(currentNode.right);
    }
    return root;
  }
}
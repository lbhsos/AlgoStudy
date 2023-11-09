/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int answer = 10000;
    public void find(TreeNode node, int level) {
        level++;
        if (node.left == null && node.right == null) {
            answer = Math.min(answer, level);
            return;
        }
        

        if (node.left != null) {
            find(node.left, level);
        }
        if (node.right != null) {
            find(node.right, level);
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            answer = 0;
            return answer;
        }
        find(root, 0);
        return answer;    
    }
}

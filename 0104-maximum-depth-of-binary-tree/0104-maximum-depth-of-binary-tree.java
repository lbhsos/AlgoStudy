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
    int answer = 0;
    public void go(int level, TreeNode node) {
        System.out.println(level);
        answer = Math.max(answer, level);

        if (node.left != null) {
            go(level + 1, node.left);
        } 
        
        if (node.right != null) {
            go(level + 1, node.right);
        }   
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return answer;
        }
        go(1, root);
        return answer;
    }
}

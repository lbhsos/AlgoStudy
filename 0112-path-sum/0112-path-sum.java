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
    private boolean answer = false;
    public void sum(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return;
        }

        currentSum += node.val;
        System.out.println(currentSum);
        if (currentSum == targetSum && (node.left == null) && (node.right == null)) {
            answer = true;
            return;
        }

        sum(node.left, targetSum, currentSum);
        sum(node.right, targetSum, currentSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {    
            return answer;
        } 

        sum(root, targetSum, 0);
        return answer;
    }
}

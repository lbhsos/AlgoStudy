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
    private List<List<Integer>> answer = new ArrayList<>();

    public void find(TreeNode node, int targetSum, int currentSum, List<Integer> route) {
        currentSum += node.val;
        route.add(node.val);
        if (node.left == null && node.right == null && currentSum == targetSum) {
            answer.add(route);
        }

        if (node.left != null) {
            find(node.left, targetSum, currentSum, new ArrayList<>(route));
        } 
        
        if (node.right != null) {
            find(node.right, targetSum, currentSum, new ArrayList<>(route));
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return answer;
        }
        find(root, targetSum, 0, new ArrayList<>());
        return answer;
    }
}

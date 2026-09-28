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
    boolean isValid = true;
    int lowerBound = Integer.MIN_VALUE;
    int upperBound = Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        dfs(root, lowerBound, upperBound);
        return isValid;
    }

    private void dfs(TreeNode node, int lowerBound, int upperBound) {
        if (node == null) return;

        if (node.val <= lowerBound || node.val >= upperBound) {
            isValid = false;
        }

        dfs(node.left, lowerBound, node.val);
        dfs(node.right, node.val, upperBound);
    }
}

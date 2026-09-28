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
    int counter = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return counter;
    }

    private void dfs(TreeNode node, int maxValue) {
        if (node == null) return;

        if (node.val >= maxValue) {
            counter++;
        }
        int newMax = Math.max(node.val, maxValue);
        dfs(node.left, newMax);
        dfs(node.right, newMax);
    }
}

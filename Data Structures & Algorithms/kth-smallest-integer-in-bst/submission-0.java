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

// In-order traversal left -> node -> right
class Solution {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k);
    }

    private int dfs(TreeNode node, int k) {
        // Reached the end of a subtree without finding the kth node
        if (node == null) return -1;

        // Search the left subtree first
        int left = dfs(node.left, k);

        // If the kth smallest was found in the left subtree,
        // propagate the result back up the recursion
        if (left != -1) {
            return left;
        }

        // Visit the current node
        // In-order traversal visits nodes in ascending order in a BST
        count++;

        // This is the kth smallest node
        if (count == k) {
            return node.val;
        }

        // Search the right subtree
        return dfs(node.right, k);
    }
}

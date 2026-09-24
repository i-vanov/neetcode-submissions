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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
            // if both values are bigger than the root, then we need to search in the right subtree
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                // If both values are smaller than the root, then we need to search in the left subtree
                root = root.left;
            } else {
                // If one is bigger/equal and the other one smaller/equal, we've found the splitting node (LCA)
                return root;
            }
        }
        return null;
    }
}

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // The queue contains the nodes we have discovered but have not processed yet
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        q.offer(root);

        while (!q.isEmpty()) {
            // Determine how many nodes are in the current level
            int levelSize = q.size();

            // For each node in the level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                // Add the last node of the level to res
                if (i == levelSize - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}

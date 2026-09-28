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

 // preorder: root -> left -> right
 // inorder: left -> root -> right
 // rootIndex = position of root in inorder
 // leftSize = rootIndex - inorderLeft

class Solution {

    private Map<Integer, Integer> inorderMap = new HashMap<>();
    // What is the next root we need to create
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        // No nodes in this subtree
        if (left > right) {
            return null;
        }

        // First unused value in preorder is the root
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootValue);

        // Find the root in inorder
        int rootIndex = inorderMap.get(rootValue);

        // Build left subtree
        root.left = build(preorder, left, rootIndex - 1);
        // Build right subtree
        root.right = build(preorder, rootIndex + 1, right);
        
        return root;
    }
}

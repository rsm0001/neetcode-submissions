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
    private int[] postOrder(TreeNode node) {
        if (null == node) { return new int[] {0, 0}; }
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);
        int maxlen = (Math.max(left[1], right[1]) + 1);
        int diameter = (left[1] + right[1]);
        int maxd = Math.max(diameter, Math.max(left[0], right[0]));
        return new int[] { maxd, maxlen };
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return postOrder(root)[0];
    }
}

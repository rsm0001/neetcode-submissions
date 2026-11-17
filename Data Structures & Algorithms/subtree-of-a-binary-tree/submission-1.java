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
    class TNode {
        public int val = 0, height = 0;
        public TNode left = null, right = null;

        public TNode(TreeNode node) {
            this.val = node.val;
            if (node.left != null) { left = new TNode(node.left); }
            if (node.right != null) { right = new TNode(node.right); }
            int lh = (null == left) ? 0 : left.height;
            int rh = (null == right) ? 0 : right.height;
            height = (Math.max(lh, rh) + 1);
        }

        public static boolean isSubTree(TNode node1, TNode node2) {
            if ((null == node1) || (null == node2)) { return false; }
            if (node1.val != node2.val) { return false; }
            if (null == node1.left) {
                if (node2.left != null) { return false; }
            } else {
                if (! node1.left.isSubTree(node2.left)) { return false; }
            }
            if (null == node1.right) {
                if (node2.right != null) { return false; }
            } else {
                if (! node1.right.isSubTree(node2.right)) { return false; }
            }
            return true;
        }

        public boolean isSubTree(TNode node) {
            if (null == node) { return false; }
            if (node.height > height) { return false; }
            if (node.height == height) {
                return isSubTree(this, node);
            }
            if (isSubTree(left, node) || isSubTree(right, node)) { return true; }
            return false;
        }
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if ((null == root) || (null == subRoot)) { return false; }
        TNode root1 = new TNode(root);
        TNode root2 = new TNode(subRoot);
        return root1.isSubTree(root2);
    }
}

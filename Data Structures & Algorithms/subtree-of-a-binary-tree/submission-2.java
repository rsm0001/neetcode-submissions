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

        static boolean sameTree(TNode a, TNode b) {
            if (a == null || b == null) return a == b;          // both null -> true
            if (a.val != b.val || a.height != b.height) return false;
            return sameTree(a.left, b.left) && sameTree(a.right, b.right);
        }

        public boolean isSubTree(TNode node) {
            if (null == node) { return false; }
            if (node.height > height) { return false; }
            if (node.height == height) {
                return sameTree(this, node);
            }
            if ((left != null) && left.isSubTree(node)) { return true; }
            if ((right != null) && right.isSubTree(node)) { return true; }
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

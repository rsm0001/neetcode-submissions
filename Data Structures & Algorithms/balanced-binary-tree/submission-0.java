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
    class NodeStats {
        public boolean balanced = true;
        public int height = 0;
    }

    private NodeStats postOrder(TreeNode node) {
        NodeStats res = new NodeStats();
        if (node != null) {
            res.balanced = false;
            NodeStats lres = postOrder(node.left);
            if (lres.balanced) {
                NodeStats rres = postOrder(node.right);
                if (rres.balanced && (Math.abs(lres.height - rres.height) <= 1)) {
                    res.height = (Math.max(lres.height, rres.height) + 1);
                    res.balanced = true;
                }
            }
        }
        return res;
    }

    public boolean isBalanced(TreeNode root) {
        NodeStats res = postOrder(root);
        return res.balanced;
    }
}

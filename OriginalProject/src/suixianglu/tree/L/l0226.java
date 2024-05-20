package suixianglu.tree.L;

import ulib.TreeNode;

public class l0226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            DFS(root);
            return root;
        }

        private void DFS(TreeNode node) {
            if (node == null) return;

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            DFS(node.right);
            DFS(node.left);
        }
    }
}

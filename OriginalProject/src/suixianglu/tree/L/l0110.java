package suixianglu.tree.L;

import ulib.TreeNode;

public class l0110 {
    public static void main(String[] args) {
        l0110 l0110 = new l0110();
        Solution s = l0110.new Solution();
        TreeNode root = new TreeNode(3);
//        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
//        root.left = left;
        root.right = right;
//        TreeNode left2 = new TreeNode(15);
//        TreeNode right2 = new TreeNode(7);
//        right.left = left2;
//        right.right = right2;

//        TreeNode left3 = new TreeNode(3);
//        TreeNode right3 = new TreeNode(3);
//        left2.left = left3;
//        left2.right = right3;
        boolean b = s.isBalanced(root);
        System.out.println(b);
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return BFS(root) >= 0;
        }

        private int BFS(TreeNode node) {
            if (node == null) return 0;
            int left = BFS(node.left);
            int right = BFS(node.right);
            if (left == -1 || right == -1) return -1;
            if (Math.abs(left - right) >= 2) return -1;
            return Math.max(left, right) + 1;
        }
    }
}

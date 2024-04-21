package suixianglu.Tree.L;

import ulib.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class l0101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        root.left = left1;
        root.right = right1;

        TreeNode first = new TreeNode(3);
        TreeNode second = new TreeNode(4);
        left1.left = first;
        left1.right = second;
        TreeNode third = new TreeNode(4);
        TreeNode forth = new TreeNode(3);
        right1.left = third;
        right1.right = forth;

        l0101 l0101 = new l0101();
        Solution s = l0101.new Solution();
        s.isSymmetric(root);
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            Deque<TreeNode> s = new ArrayDeque<>();
            Deque<TreeNode> s2 = new ArrayDeque<>();

            if (root.left != null && root.right != null) {
                s.addLast(root.left);
                s2.addLast(root.right);
            } else return root.left == null && root.right == null;

            while (!s.isEmpty()) {
                TreeNode node1 = s.pollFirst();
                TreeNode node2 = s2.pollLast();
                if (node2 != null && node1.val == node2.val) {
                    if (node1.left != null && node2.right != null) {
                        s.addLast(node1.left);
                        s2.addFirst(node2.right);
                    } else if (node1.left != null || node2.right != null) {
                        return false;
                    }

                    if (node1.right != null && node2.left != null) {
                        s.addLast(node1.right);
                        s2.addFirst(node2.left);
                    } else if (node1.right != null || node2.left != null) {
                        return false;
                    }
                } else return false;

            }

            return s2.isEmpty();
        }
    }
}

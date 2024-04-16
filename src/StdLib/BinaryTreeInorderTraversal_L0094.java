package StdLib;

import java.util.*;

public class BinaryTreeInorderTraversal_L0094 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        List<Integer> list;

        public List<Integer> inorderTraversal(TreeNode root) {
            list = new ArrayList<>();
//            inorderIterative(root);
//            inorderRecursive(root);
            inorderIterativeUniversal(root);
            return list;
        }

        public void inorderRecursive(TreeNode node) {
            if (node != null) {
                inorderRecursive(node.left);
                list.add(node.val);
                inorderRecursive(node.right);
            }
        }

        public void inorderIterative(TreeNode node) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            while (!(node == null && stack.isEmpty())) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    list.add(node.val);
                    node = node.right;
                }
            }
        }

        public void inorderIterativeUniversal(TreeNode node) {
            // 这里要用Stack不能用Deque，Deque的push方法不允许push(null)
            Stack<TreeNode> stack = new Stack<>();
            if (node != null) stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node != null) {
                    if (node.right != null) stack.push(node.right);
                    stack.push(node);
                    stack.push(null);
                    if (node.left != null) stack.push(node.left);
                } else {
                    node = stack.pop();
                    list.add(node.val);
                }
            }
        }
    }
}

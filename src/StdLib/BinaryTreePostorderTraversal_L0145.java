package StdLib;

import java.util.*;

import ULib.TreeNode;


public class BinaryTreePostorderTraversal_L0145 {

    class Solution {
        List<Integer> list;

        public List<Integer> postorderTraversal(TreeNode root) {
            list = new ArrayList<>();
//            postorderRecursive(root);
//            postorderIterative(root);
            postorderIterativeUniversal(root);
            return list;
        }

        public void postorderRecursive(TreeNode node) {
            if (node != null) {
                postorderRecursive(node.left);
                postorderRecursive(node.right);
                list.add(node.val);
            }
        }

        public void postorderIterative(TreeNode node) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            if (node == null) return;
            stack.push(node);

            while (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }

            Collections.reverse(list);
        }

        public void postorderIterativeUniversal(TreeNode node) {
            // 这里要用Stack不能用Deque，Deque的push方法不允许push(null)
            Stack<TreeNode> stack = new Stack<>();
            if (node != null) stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node != null) {
                    stack.push(node);
                    stack.push(null);
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                } else {
                    node = stack.pop();
                    list.add(node.val);
                }
            }
        }
    }

}

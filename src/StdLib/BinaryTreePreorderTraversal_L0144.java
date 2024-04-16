package StdLib;

import java.util.*;

import ULib.TreeNode;


public class BinaryTreePreorderTraversal_L0144 {

    class Solution {
        List<Integer> list;

        public List<Integer> preorderTraversal(TreeNode root) {
            list = new ArrayList<>();
//            preorderRecursive(root);
//            preorderIterative(root);
            preorderIterativeUniversal(root);
            return list;
        }

        public void preorderRecursive(TreeNode node) {
            if (node != null) list.add(node.val);
            else return;
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }

        public void preorderIterative(TreeNode node) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            if (node == null) return;
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }

        public void preorderIterativeUniversal(TreeNode node) {
            // 这里要用Stack不能用Deque，Deque的push方法不允许push(null)
            Stack<TreeNode> stack = new Stack<>();
            if (node != null) stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node != null) {
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                    stack.push(node);
                    stack.push(null);
                } else {
                    node = stack.pop();
                    list.add(node.val);
                }
            }
        }
    }
}

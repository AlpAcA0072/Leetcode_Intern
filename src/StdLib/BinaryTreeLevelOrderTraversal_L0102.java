package StdLib;

import java.util.*;

import UsefulLib.TreeNode;


public class BinaryTreeLevelOrderTraversal_L0102 {

    class Solution {
        List<List<Integer>> list;

        public List<List<Integer>> levelOrder(TreeNode root) {
            list = new ArrayList<>();
//            levelOrderTraversalIterative(root);
//            levelOrderTraversalIterative2(root);
            levelOrderTraversalRecursive(root, 0);
            return list;
        }

        // 非常不优雅的迭代写法:
        private void levelOrderTraversalIterative(TreeNode node) {
            Deque<TreeNode> levelList = new LinkedList<>();
            if (node != null) levelList.addLast(node);
            while (!levelList.isEmpty()) {
                List<Integer> levelValue = new ArrayList<>();
                Deque<TreeNode> nextLevel = new LinkedList<>();
                while (!levelList.isEmpty()) {
                    node = levelList.removeFirst();
                    // 多迭代了一层到叶子节点的下一层null
                    if (node != null) {
                        levelValue.add(node.val);
                        nextLevel.addLast(node.left);
                        nextLevel.addLast(node.right);
                    }
                }
                levelList = nextLevel;
                if (!levelValue.isEmpty()) list.add(levelValue);
            }
        }

        private void levelOrderTraversalIterative2(TreeNode node) {
            Queue<TreeNode> queue = new LinkedList<>();
            if (node != null) queue.add(node);

            while (!queue.isEmpty()) {
                List<Integer> valueList = new ArrayList<>();
                for (int len = queue.size(); len > 0; len--) {
                    node = queue.remove();
                    valueList.add(node.val);

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                list.add(valueList);
            }
        }

        private void levelOrderTraversalRecursive(TreeNode node, int depth) {
            if (node != null) {
                if (list.size() < depth + 1) {
                    list.add(new ArrayList<>(1));
                }
                list.get(depth).add(node.val);
                levelOrderTraversalRecursive(node.left, depth + 1);
                levelOrderTraversalRecursive(node.right, depth + 1);
            }
        }
    }
}

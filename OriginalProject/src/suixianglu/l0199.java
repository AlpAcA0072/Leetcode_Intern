package suixianglu;

import java.util.*;

import ulib.TreeNode;


public class l0199 {

    class Solution {
        List<Integer> results;

        public List<Integer> rightSideView(TreeNode root) {
            results = new ArrayList<>();
            levelOrderTraversalRecursive(root, 0);
            return results;
        }

        private void levelOrderTraversalRecursive(TreeNode node, int depth) {
            if (node != null) {
                if (results.size() < depth + 1) {
                    results.add(Integer.MAX_VALUE);
                }

                if (results.get(depth) == Integer.MAX_VALUE) {
                    results.set(depth, node.val);
                }
                levelOrderTraversalRecursive(node.right, depth + 1);
                levelOrderTraversalRecursive(node.left, depth + 1);
            }
        }


    }

    // l0107层序遍历代码复用，稍微修改一下
    class Solution2 {
        List<List<Integer>> levelResults;

        public List<Integer> rightSideView(TreeNode root) {
            levelResults = new ArrayList<>();
            levelOrderTraversalRecursive(root, 0);
            List<Integer> result = new ArrayList<>(levelResults.size());
            for (List<Integer> levelResult : levelResults) {
                result.add(levelResult.get(0));
            }
            return result;
        }

        private void levelOrderTraversalRecursive(TreeNode node, int depth) {
            if (node != null) {
                if (levelResults.size() < depth + 1) {
                    levelResults.add(new ArrayList<>());
                }

                levelResults.get(depth).add(node.val);
                levelOrderTraversalRecursive(node.right, depth + 1);
                levelOrderTraversalRecursive(node.left, depth + 1);
            }
        }


    }

}

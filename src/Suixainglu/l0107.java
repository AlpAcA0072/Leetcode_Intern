package Suixainglu;

import java.util.*;

import ULib.TreeNode;

public class l0107 {

    class Solution {
        private List<List<Integer>> result;

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            result = new ArrayList<>();
            levelOrderTraversalRecursive(root, 0);
            Collections.reverse(result);
            return result;
        }

        private void levelOrderTraversalRecursive(TreeNode node, int depth) {
            if (node != null) {
                if (result.size() < depth + 1) {
                    result.add(new ArrayList<>());
                }

                result.get(depth).add(node.val);
                levelOrderTraversalRecursive(node.left, depth + 1);
                levelOrderTraversalRecursive(node.right, depth + 1);
            }
        }
    }
}

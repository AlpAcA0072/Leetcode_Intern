package suixianglu;

import java.util.*;

import ulib.TreeNode;

public class l0637 {
    class Solution {
        private List<Double> arr;
        List<Integer> depthSize = new LinkedList<>();

        public List<Double> averageOfLevels(TreeNode root) {
            arr = new ArrayList<>();
            levelOrderTraversal(root, 0);
            for (int i = 0; i < arr.size(); i++) {
                arr.set(i, arr.get(i) / depthSize.get(i));
            }
            return arr;
        }

        private void levelOrderTraversal(TreeNode node, int depth) {
            if (node != null) {
                if (depth + 1 > arr.size()) {
                    arr.add(0d);
                    depthSize.add(0);
                }

                arr.set(depth, arr.get(depth) + node.val);
                depthSize.set(depth, depthSize.get(depth) + 1);
                levelOrderTraversal(node.left, depth + 1);
                levelOrderTraversal(node.right, depth + 1);
            }
        }
    }
}

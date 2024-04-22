package suixianglu.tree.L;

import java.util.*;

import ulib.TreeNode;

public class l0515 {
    class Solution {
        List<Integer> arr = new ArrayList<>();

        public List<Integer> largestValues(TreeNode root) {
            findMaxInLayer(root, 0);
            return arr;
        }

        private void findMaxInLayer(TreeNode node, int depth) {
            if (node != null) {
                if (depth + 1 > arr.size()) {
                    arr.add(Integer.MIN_VALUE);
                }

                arr.set(depth, Math.max(arr.get(depth), node.val));
                findMaxInLayer(node.left, depth + 1);
                findMaxInLayer(node.right, depth + 1);
            }
        }

    }
}

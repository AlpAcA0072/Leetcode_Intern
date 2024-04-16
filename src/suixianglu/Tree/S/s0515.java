package suixianglu.Tree.S;

import java.util.*;

import ulib.TreeNode;

public class s0515 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            List<Integer> res = new ArrayList<Integer>();
            dfs(res, root, 0);
            return res;
        }

        public void dfs(List<Integer> res, TreeNode root, int curHeight) {
            if (curHeight == res.size()) {
                res.add(root.val);
            } else {
                res.set(curHeight, Math.max(res.get(curHeight), root.val));
            }
            if (root.left != null) {
                dfs(res, root.left, curHeight + 1);
            }
            if (root.right != null) {
                dfs(res, root.right, curHeight + 1);
            }
        }
    }

    class Solution2 {
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            List<Integer> res = new ArrayList<Integer>();
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                int maxVal = Integer.MIN_VALUE;
                while (len > 0) {
                    len--;
                    TreeNode t = queue.poll();
                    maxVal = Math.max(maxVal, t.val);
                    if (t.left != null) {
                        queue.offer(t.left);
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    }
                }
                res.add(maxVal);
            }
            return res;
        }
    }
}

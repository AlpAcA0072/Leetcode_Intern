package leetcodeHot100.L;

import ulib.*;

import java.util.*;

// TODO: 重复练习
public class l0437 {
    public static void main(String[] args) {
        l0437 l0437 = new l0437();
        Solution s = l0437.new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        s.pathSum(root, 2);
    }

    // 本质上是O(n ^ 2)的方法
    class Solution {
        int count = 0;
        int targetSum;
        List<Long> postSums;

        // 后缀和的坏处是当更新节点时需要更新节点里的每个值，这是个O(n)的操作
        public int pathSum(TreeNode root, int targetSum) {
            // DFS
            // 后缀和数组
            // arr = [10, 5, 3, 3, i]
            // postSum = [21, 11, 6, 3, i]
            postSums = new LinkedList<>();
            this.targetSum = targetSum;
            if (root != null) {
                if (root.val == targetSum) count++;
                postSums.add((long) root.val);
                DFSRecursive(root);
            }

            return count;
        }

        private void calculate(TreeNode node) {
            int val = node.val;
            for (int i = 0; i < postSums.size(); i++) {
                long postSum = postSums.get(i);
                if (postSum + val == targetSum) {
                    count++;
                }
                postSums.set(i, postSum + val);
            }
            if (node.val == targetSum) count++;
            postSums.add((long) node.val);
        }

        private void DFSRecursive(TreeNode node) {
            if (node.left != null) {
                calculate(node.left);
                DFSRecursive(node.left);
            }

            if (node.right != null) {
                calculate(node.right);
                DFSRecursive(node.right);
            }

            int n = postSums.size();
            long val = postSums.get(n - 1);
            postSums.remove(n - 1);
            postSums.replaceAll(integer -> integer - val);
        }
    }

    // 前缀和的好处是一次性计算，不需要再更新值了
    class Solution2 {
        int count = 0;
        int targetSum;
        Map<Long, Integer> preSums = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            preSums.put(0L, 1);
            if (root != null) {
                DFSRecursive(root, 0L);
            }
            return count;
        }

        private void DFSRecursive(TreeNode node, long totalSum) {
            int val = node.val;
            totalSum += val;
            // totalSum - preSum = targetSum
            // totalSum - targetSum = preSum = Map(key)
            long key = totalSum - targetSum;
            int numberOfRoute = preSums.getOrDefault(key, 0);
            count += numberOfRoute;
            preSums.put(totalSum, preSums.getOrDefault(totalSum, 0) + 1);
            if (node.left != null) DFSRecursive(node.left, totalSum);
            if (node.right != null) DFSRecursive(node.right, totalSum);
            preSums.put(totalSum, preSums.getOrDefault(totalSum, 0) - 1);
        }
    }
}

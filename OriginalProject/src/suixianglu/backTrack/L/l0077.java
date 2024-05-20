package suixianglu.backTrack.L;

import java.util.*;

public class l0077 {
    public static void main(String[] args) {
        l0077 l0077 = new l0077();
        Solution s = l0077.new Solution();
        s.combine(4, 2);
    }

    // TODO: 时间复杂度分析
    // https://leetcode.cn/problems/combinations/description/
    // 18ms 89.93MB
    class Solution {
        List<List<Integer>> lists;
        List<Integer> arr;

        public List<List<Integer>> combine(int n, int k) {
            lists = new ArrayList<>();
            arr = new ArrayList<>();
            backtracking(n, k, 1);
            return lists;
        }

        private void backtracking(int n, int k, int depth) {
            if (depth > k) {
                // 注意copyOf
                lists.add(List.copyOf(arr));
                // 错误方式
//                lists.add(arr);
                return;
            }

            int i = 1;
            if (!arr.isEmpty()) i = arr.get(arr.size() - 1) + 1;
            for (; i <= n - k + depth; i++) {
                arr.add(i);
                backtracking(n, k, depth + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }

    // 18-19ms 89.73MB
    class Solution2 {
        List<List<Integer>> lists;
        List<Integer> arr;

        public List<List<Integer>> combine(int n, int k) {
            lists = new ArrayList<>();
            arr = new ArrayList<>();
            backtracking(n, k, 1);
            return lists;
        }

        private void backtracking(int n, int k, int depth) {
            int i = 1;
            if (!arr.isEmpty()) i = arr.get(arr.size() - 1) + 1;
            for (; i <= n - k + depth; i++) {
                arr.add(i);
                if (depth == k) {
                    lists.add(List.copyOf(arr));
                } else {
                    backtracking(n, k, depth + 1);
                }
                arr.remove(arr.size() - 1);
            }
        }
    }

}

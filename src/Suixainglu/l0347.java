package Suixainglu;

import java.util.*;

public class l0347 {
    public static void main(String[] args) {
        l0347 l0347 = new l0347();
        Solution solution = l0347.new Solution();
        solution.topKFrequent(new int[]{1, 2}, 2);
    }

    // map + 部分快排
    // 理论最优时间复杂度: O(n)
    // 理论平均时间复杂度: O(n * log(n))
    // 理论最坏时间复杂度: O(n ^ 2)
    class Solution {
        private int kIndex;
        ArrayList<int[]> arr = new ArrayList<>();


        public int[] topKFrequent(int[] nums, int k) {
            kIndex = k - 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            map.forEach((K, V) -> arr.add(new int[]{K, V}));

            // 我们现在的问题是如何用O(n)的时间复杂度找到无序列表的第k大元素
            // 部分快排
            kthLargest(0, arr.size() - 1);
            int[] re = new int[k];
            for (int i = 0; i < k; i++) {
                re[i] = arr.get(i)[0];
            }
            return re;
        }

        private void kthLargest(int start, int end) {
            int[] pivot = arr.get(start);
            int left = start, right = end;

            while (left != right) {
                while (left < right && arr.get(right)[1] <= pivot[1]) {
                    right--;
                }
                arr.set(left, arr.get(right));
                while (left < right && arr.get(left)[1] >= pivot[1]) {
                    left++;
                }
                arr.set(right, arr.get(left));
            }

            // left和right相等
            arr.set(left, pivot);

            if (kIndex < left) kthLargest(start, left - 1);
            if (kIndex > left) kthLargest(left + 1, end);
        }
    }
}

package Suixainglu;

import java.util.*;

public class s0347 {
    // 大顶堆可秒
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
            for (int num : nums) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
            PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] m, int[] n) {
                    return m[1] - n[1];
                }
            });
            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                if (queue.size() == k) {
                    if (queue.peek() != null && queue.peek()[1] < count) {
                        queue.poll();
                        queue.offer(new int[]{num, count});
                    }
                } else {
                    queue.offer(new int[]{num, count});
                }
            }
            int[] ret = new int[k];
            for (int i = 0; i < k; ++i) {
                ret[i] = Objects.requireNonNull(queue.poll())[0];
            }
            return ret;
        }
    }

    // 基于快排
    class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
            for (int num : nums) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }
            // 获取每个数字出现次数
            List<int[]> values = new ArrayList<int[]>();
            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                values.add(new int[]{num, count});
            }
            int[] ret = new int[k];
            qsort(values, 0, values.size() - 1, ret, 0, k);
            return ret;
        }

        public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
            int picked = (int) (Math.random() * (end - start + 1)) + start;
            Collections.swap(values, picked, start);

            int pivot = values.get(start)[1];
            int index = start;
            for (int i = start + 1; i <= end; i++) {
                // 使用双指针把不小于基准值的元素放到左边，
                // 小于基准值的元素放到右边
                if (values.get(i)[1] >= pivot) {
                    Collections.swap(values, index + 1, i);
                    index++;
                }
            }
            Collections.swap(values, start, index);

            if (k <= index - start) {
                // 前 k 大的值在左侧的子数组里
                qsort(values, start, index - 1, ret, retIndex, k);
            } else {
                // 前 k 大的值等于左侧的子数组全部元素
                // 加上右侧子数组中前 k - (index - start + 1) 大的值
                for (int i = start; i <= index; i++) {
                    ret[retIndex++] = values.get(i)[0];
                }
                if (k > index - start + 1) {
                    qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
                }
            }
        }
    }
}

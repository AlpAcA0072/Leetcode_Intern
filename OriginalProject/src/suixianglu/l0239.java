package suixianglu;

import java.util.*;

public class l0239 {
    public static void main(String[] args) {
        l0239 l0239 = new l0239();
        Solution3 solution3 = l0239.new Solution3();
        Solution4 solution4 = l0239.new Solution4();
        solution3.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        solution4.maxSlidingWindow(new int[]{1}, 1);
    }

    // TODO: 复杂度分析?
    // TLE in LeetCode
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
            PriorityQueue<Integer> toDelete = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

            for (int i = 0; i < k; i++) {
                pq.add(nums[i]);
            }

            int[] re = new int[nums.length - k + 1];
            for (int ptr = k; ptr < nums.length; ptr++) {
                assert !pq.isEmpty();
                re[ptr - k] = pq.peek();
                int num = nums[ptr - k];
                assert pq.contains(num);
                // 如果当前值小于最大值，那么删除与否都不会影响下一轮的结果
                // 可以暂时不删除
                if (num < pq.peek()) {
                    toDelete.add(num);
                } else {
                    pq.remove(num);
                    Integer[] arr = toDelete.toArray(new Integer[pq.size()]);
                    for (Integer i : arr) {
                        pq.remove(i);
                    }
                    toDelete = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
                }
                pq.add(nums[ptr]);
            }
            assert !pq.isEmpty();
            re[nums.length - k] = pq.peek();

            return re;
        }
    }

    // PQ with [value, index] tuple
    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // int[] = {nums[index], index in nums}
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> o2[0] - o1[0]);

            for (int i = 0; i < k; i++) {
                pq.add(new int[]{nums[i], i});
            }

            int[] re = new int[nums.length - k + 1];
            for (int ptr = k - 1; ptr < nums.length; ptr++) {
                int leftBound = ptr - k;

                // delete
                // 最耗费时间的步骤
                while (!pq.isEmpty() && pq.peek()[1] <= leftBound) {
                    pq.poll();
                }

                // add
                pq.add(new int[]{nums[ptr], ptr});

                // peek and set value
                if (!pq.isEmpty()) {
                    re[leftBound + 1] = pq.peek()[0];
                } else throw new NullPointerException("PQ is empty!");
            }

            return re;
        }
    }

    // 维持一个滑动窗口中:
    // index递增 min -----> max
    // value (nums[index]) 递减的单调队列 max -----> min
    // 证明:
    // 如果 i < j 且 nums[i] < nums[j]
    // 当 i 在滑动窗口中时，j 也一定在，并且因为nums[i] < nums[j]，nums[i]不可能为滑动窗口中的最大值。
    // 所以我们无需保证 i 在我们维持的滑动窗口对象中，可以提前将其删除。
    class Solution3 {
        private void ensurePriority(Deque<int[]> dq, int value, int leftBound) {
            while (!dq.isEmpty() && dq.getFirst()[1] < leftBound) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && dq.getLast()[0] <= value) {
                dq.removeLast();
            }

        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            // int[] = {nums[index], index in nums}
            Deque<int[]> dq = new LinkedList<>();

            // max(i) = k - 2
            // 不完整初始化最左侧的滑动窗口(留下最右侧的元素不初始化)，在下面遍历的时候初始化滑动窗口最后一个，避免判断特殊情况。
            for (int i = 0; i < k - 1; i++) {
                int currValue = nums[i];
                ensurePriority(dq, currValue, 0);
                dq.add(new int[]{currValue, i});
            }

            int[] re = new int[nums.length - k + 1];
            int value, leftBound;
            for (int ptr = k - 1; ptr < nums.length; ptr++) {
                // leftBound指向滑动窗口最左侧的元素
                // ptr指向滑动窗口最右侧元素
                leftBound = ptr - k + 1;

                value = nums[ptr];

                // delete
                ensurePriority(dq, value, leftBound);

                // add
                dq.add(new int[]{nums[ptr], ptr});

                // peek and set value
                re[leftBound] = dq.peek()[0];
            }

            return re;
        }
    }

    class Solution4 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 计算prefixMax和postfixMax数组
            int[] prefixMax = new int[nums.length];
            int[] postfixMax = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if (i % k == 0) {
                    prefixMax[i] = nums[i];
                } else {
                    prefixMax[i] = Math.max(nums[i], prefixMax[i - 1]);
                }
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                // 如果i是最后一个
                // 或者i的位置的右侧是下一个block的开头
                if (i == nums.length - 1 || (i + 1) % k == 0) {
                    postfixMax[i] = nums[i];
                } else {
                    postfixMax[i] = Math.max(nums[i], postfixMax[i + 1]);
                }
            }


            int indexRe;
            int[] re = new int[nums.length - k + 1];
            for (int ptr = k - 1; ptr < nums.length; ptr++) {
                // indexRe指向滑动窗口最左侧的元素
                // ptr指向滑动窗口最右侧元素
                indexRe = ptr - k + 1;

                re[indexRe] = Math.max(prefixMax[ptr], postfixMax[indexRe]);
            }

            return re;
        }
    }
}

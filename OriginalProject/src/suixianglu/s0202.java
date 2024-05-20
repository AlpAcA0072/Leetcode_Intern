package suixianglu;

import java.util.*;

public class s0202 {
    // 该算法的输出结果不会一直变大
    // 对于 3 位数的数字，它不可能大于 243。这意味着它要么被困在 243 以下的循环内，要么跌到 1。4 位或 4 位以上的数字在每一步都会丢失一位，直到降到 3 位为止。所以我们知道，最坏的情况下，算法可能会在 243 以下的所有数字上循环，然后回到它已经到过的一个循环或者回到 1。但它不会无限期地进行下去。

    // 时间复杂度：O(243⋅3 + log(n) + log(log(n)) + log(log(log(b))) + ... = O(log(n))
    //
    class Solution {
        private int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }

        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getNext(n);
            }
            return n == 1;
        }
    }

    // 问题本质上是确定链表也没有环，那么自然可以用快慢指针法。
    class Solution2 {

        public int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }

        public boolean isHappy(int n) {
            int slowRunner = n;
            int fastRunner = getNext(n);
            while (fastRunner != 1 && slowRunner != fastRunner) {
                slowRunner = getNext(slowRunner);
                fastRunner = getNext(getNext(fastRunner));
            }
            return fastRunner == 1;
        }
    }

    // 数学分析法
    // 三位数，也即243 (= 9 ^ 2 + 9 ^ 2 + 9 ^ 2)以下的循环只有一个:
    // 4 --> 16 --> 37 --> 58 --> 89 --> 145 --> 42 --> 20 --> 4
    // 那么当原数字快速收敛至三位数以内时，只要判断该数字是否在这几个数字之中就可以得出结论了。
    class Solution3 {

        private static Set<Integer> cycleMembers =
                new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

        public int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }


        public boolean isHappy(int n) {
            while (n != 1 && !cycleMembers.contains(n)) {
                n = getNext(n);
            }
            return n == 1;
        }
    }
}

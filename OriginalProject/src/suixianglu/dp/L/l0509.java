package suixianglu.dp.L;

public class l0509 {

    // dp
    // 初始化 f(0) = 0, f(1) = 1
    // 状态转移 f(n) = f(n - 1) + f(n - 2)
    // dp dp[i] = dp[i - 1] + dp[i - 2]
    // 其中i是第i个fibonacci的值
    // 我们可以只用两个数存储i - 1和i - 2的值，而不需要一个数组
    class Solution {
        public int fib(int n) {
            int f0 = 0, f1 = 1;
            if (n <= 1) return n;
            for (int i = 2; i <= n; i++) {
                int f2 = f0 + f1;
                f0 = f1;
                f1 = f2;
            }
            return f1;
        }
    }

    class Solution2 {
        public int fib(int n) {
            if (n <= 1) return n;
            int n2 = 0;
            int n1 = 1;
            int temp;
            for (int i = 2; i <= n; i++) {
                temp = n1;
                n1 += n2;
                n2 = temp;
            }

            return n1;
        }
    }
}

package suixianglu.dp.L;

public class l0343 {
    public static void main(String[] args) {
        l0343 l0343 = new l0343();
        Solution s = l0343.new Solution();
        s.integerBreak(10);
    }

    class Solution {
        public int integerBreak(int n) {
            // dp[i] = max value of i
            int[] dp = new int[n + 1];
            if (n <= 2) return 1;
            // dp[0] 无意义
            dp[1] = 1;
            dp[2] = 1;


            for (int i = 3; i <= n; i++) {
                // j不需要到i，到i/2即可
                // (i - j) * j: 7 * 3 / 3 * 7
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i], (i - j) * j);
                    dp[i] = Math.max(dp[i], dp[i - j] * j);
                }
            }

            return dp[n];
        }
    }
}

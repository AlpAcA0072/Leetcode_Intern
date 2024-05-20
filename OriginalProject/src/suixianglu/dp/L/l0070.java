package suixianglu.dp.L;

public class l0070 {
    // 0509的拓展
    class Solution {
        public int climbStairs(int n) {
            // dp[n] = dp[n - 1] + dp[n - 2]
            // dp[1] = 1, dp[2] = 2
            int s1 = 1, s2 = 2;
            if (n <= 2) return n;
            for (int i = 3; i <= n; i++) {
                int s3 = s1 + s2;
                s1 = s2;
                s2 = s3;
            }
            return s2;
        }
    }
}

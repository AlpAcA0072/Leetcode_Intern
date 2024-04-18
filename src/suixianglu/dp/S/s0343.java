package suixianglu.dp.S;

public class s0343 {
    class Solution {
        public int integerBreak(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
            }
            return dp[n];
        }
    }


    // 数学法: https://leetcode.cn/problems/integer-break/solutions/352875/zheng-shu-chai-fen-by-leetcode-solution
    class Solution2 {
        public int integerBreak(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int quotient = n / 3;
            int remainder = n % 3;
            if (remainder == 0) {
                return (int) Math.pow(3, quotient);
            } else if (remainder == 1) {
                return (int) Math.pow(3, quotient - 1) * 4;
            } else {
                return (int) Math.pow(3, quotient) * 2;
            }
        }
    }
}

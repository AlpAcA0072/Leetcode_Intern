package suixianglu.greedy.S;

public class s0122 {
    // dp
    // i: 第i天，0/1: 不持有/持有股票
    // dp[i][0] = max{dp[i−1][0], dp[i−1][1] + prices[i]}
    // max{继续前一天持有，卖出前一天持有获得收益}
    // dp[i][1] = max{dp[i−1][1], dp[i−1][0] − prices[i]}
    // max{继续前一天不持有，买入股票消耗金钱}
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }

    // 每一天的状态只与前一天的状态有关，而与更早的状态都无关，因此我们不必存储这些无关的状态，只需要将 dp[i−1][0] 和 dp[i−1][1] 存放在两个变量中，通过它们计算出 dp[i][0] 和 dp[i][1] 并存回对应的变量，以便于第 i+1 天的状态转移即可。
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return dp0;
        }
    }

    // 好贪的贪心
    class Solution3 {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int n = prices.length;
            for (int i = 1; i < n; ++i) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
    }
}

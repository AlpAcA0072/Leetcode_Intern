package suixianglu.dp.L;

public class l0746 {
    public static void main(String[] args) {
        l0746 l0746 = new l0746();
        Solution s = l0746.new Solution();
        s.minCostClimbingStairs(new int[]{10, 15, 20});
    }

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length + 1;
            int[] dp = new int[n];

            for (int i = 2; i < n; ++i) {
                dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            }

            return dp[n - 1];
        }
    }
}

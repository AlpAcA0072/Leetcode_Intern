package suixianglu;

public class l0122 {
    public static void main(String[] args) {
        l0122 l0122 = new l0122();
        Solution solution = l0122.new Solution();
        solution.maxProfit(new int[]{2, 2, 5});
    }
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            if (n == 1) return 0;
            if (n == 2) {
                return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
            }

            int total_profit = 0;
            for (int i = 1; i < n - 1; i++) {
                if (prices[i] > prices[i + 1]) {
                    total_profit += prices[i];
                }
                if (prices[i] < prices[i - 1]) {
                    total_profit -= prices[i];
                }
            }
            if (prices[0] <= prices[1]) {
                total_profit -= prices[0];
            }
            if (prices[n - 2] <= prices[n - 1]) {
                total_profit += prices[n - 1];
            }
            return total_profit;
        }
    }
}

package suixianglu.greedy.L;

public class l0122 {
    public static void main(String[] args) {
        l0122 l = new l0122();
        Solution s = l.new Solution();
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    // 模拟还是low了
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) return 0;
            int maxProfits = 0;
            int buyDay = 0, sellDay;
            while (buyDay < prices.length - 1) {
                while (buyDay <= prices.length - 2 && prices[buyDay + 1] <= prices[buyDay]) {
                    buyDay++;
                }

                sellDay = buyDay;
                while (sellDay <= prices.length - 2 && prices[sellDay + 1] >= prices[sellDay]) {
                    sellDay++;
                }

                maxProfits += Math.max(0, prices[sellDay] - prices[buyDay]);
                buyDay = sellDay + 1;
            }

            return maxProfits;
        }
    }
}

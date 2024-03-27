package Suixainglu;

public class l0209 {
    public static void main(String[] args) {
        l0209 l0209 = new l0209();
        Solution solution = l0209.new Solution();
        int result = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(result);
    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minLen = Integer.MAX_VALUE;
            int st = 0, end = 0;
            int sum = 0;
            if (nums.length == 0) return nums.length;

            while (end < nums.length) {
                // 这里没有对 end 的 while 循环。
                // 从而避免考虑 end 的边界情况。
                sum += nums[end];
                while (sum >= target) {
                    minLen = Math.min(minLen, end - st + 1);
                    sum -= nums[st];
                    st++;
                }
                end++;
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}

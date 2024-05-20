package leetcodeHot100.L;

public class l0198 {
    class Solution {
        public int rob(int[] nums) {
            // dp[i]为i处最大偷窃
            // dp[i] = max( dp[i - 2] + m[i],
            //              dp[i - 3] + m[i])
            // 不用dp[i - 4]是因为如果能偷i - 4处，那么一定能偷i - 2，所以dp[i - 2] >= dp[i - 4]
            // dp[i - 5]同理
            int max = nums[0];
            int n = nums.length;

            if (n <= 2) {
                for (int i = 1; i < n; i++) {
                    max = Math.max(max, nums[i]);
                }
                return max;
            }

            nums[2] += nums[0];

            for (int i = 3; i < n; i++) {
                nums[i] += Math.max(nums[i - 2], nums[i - 3]);
            }

            return Math.max(nums[n - 1], nums[n - 2]);
        }
    }
}

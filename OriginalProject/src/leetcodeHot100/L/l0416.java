package leetcodeHot100.L;

public class l0416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n == 1) return false;

            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }

            if (sum % 2 != 0) return false;
            int target = sum / 2;
            if (max > target) return false;
            else if (max == target) return true;


            boolean[][] dp = new boolean[n][target + 1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;

            for (int i = 1; i < n; i++) {
                int num = nums[i];
                for (int j = 0; j < dp[i].length; j++) {
                    if (j >= num) {
                        dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - num]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[n - 1][target];
        }
    }
}

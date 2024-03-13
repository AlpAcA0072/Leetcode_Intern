public class l0053 {

    // time O(n^2), space O(1) TLE
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    maxSum = Math.max(maxSum, sum);
                }
            }

            return maxSum;
        }
    }

    //
    class Solution2 {
        public int maxSubArray(int[] nums) {
            return Integer.MIN_VALUE;
        }
    }
}

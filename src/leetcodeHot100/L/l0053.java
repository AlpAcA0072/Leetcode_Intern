package leetcodeHot100.L;

public class l0053 {
    // time O(n^2), space O(1) TLE
    // Brute Force with memory
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

    // time O(n), space O(1)
    // sum(i, j) (from index i to j) = sum(0, j) - sum(0, i - 1)
    // maxSum = maxSum(0, ?) - minSum(0, ?)
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int maxResult = nums[0];
            int minSum = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                maxResult = Math.max(maxResult, sum - minSum);
                minSum = Math.min(minSum, sum);
            }
            return maxResult;
        }
    }

    // divide and conquer
    // time O(n*log(n)), space O(1)
    // TODO
    class Solution3 {
        public int maxSubArray(int[] nums) {
            return -1;
        }
    }

    // dp
    // time O(n), space O(1)
    // TODO
    class Solution4 {
        public int maxSubArray(int[] nums) {
            return -1;
        }
    }
}

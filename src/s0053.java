public class s0053 {

    // divide and conquer
    class MaximumSubarrayDivideConquer {
        public int maxSubArrayDividConquer(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            return helper(nums, 0, nums.length - 1);
        }
        private int helper(int[] nums, int l, int r) {
            if (l > r) return Integer.MIN_VALUE;
            int mid = (l + r) >>> 1;
            int left = helper(nums, l, mid - 1);
            int right = helper(nums, mid + 1, r);
            int leftMaxSum = 0;
            int sum = 0;
            // left surfix maxSum start from index mid - 1 to l
            for (int i = mid - 1; i >= l; i--) {
                sum += nums[i];
                leftMaxSum = Math.max(leftMaxSum, sum);
            }
            int rightMaxSum = 0;
            sum = 0;
            // right prefix maxSum start from index mid + 1 to r
            for (int i = mid + 1; i <= r; i++) {
                sum += nums[i];
                rightMaxSum = Math.max(sum, rightMaxSum);
            }
            // max(left, right, crossSum)
            return Math.max(leftMaxSum + rightMaxSum + nums[mid], Math.max(left, right));
        }
    }

    // dp
    class MaximumSubarrayDP {
        public int maxSubArray(int[] nums) {
            int currMaxSum = nums[0];
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
                maxSum = Math.max(maxSum, currMaxSum);
            }
            return maxSum;
        }
    }
}

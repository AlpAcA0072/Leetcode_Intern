package suixianglu;

public class l0724 {
    public static void main(String[] args) {
        l0724 l0724 = new l0724();
        Solution s = l0724.new Solution();
        System.out.println(s.pivotIndex(new int[]{1, 2, 3}));
    }

    // !!!错误方法
    // 二分不行，因为二分要求数组是有序的，但是该前缀和数组不一定有序
    class Solution {
        public int pivotIndex(int[] nums) {
            int currSum = 0;
            int[] sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                sums[i] = currSum;
            }
            int l = 0;
            int r = nums.length - 1;
            int sum = sums[nums.length - 1];
            while (l < r) {
                int mid = (l + r) / 2;
                int leftSum = sums[mid] - nums[mid];
                int rightSum = sum - sums[mid];
                if (rightSum < leftSum) {
                    r = mid;
                } else if (rightSum > leftSum) l = mid + 1;
                else return mid;
            }
            while (l >= 1 && nums[l - 1] == nums[l]) {
                l--;
            }
            return sum - nums[l] == sum - sums[l] ? l : -1;
        }
    }

    class Solution2 {
        public int pivotIndex(int[] nums) {
            int currSum = 0;
            int[] sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                sums[i] = currSum;
            }
            int sum = sums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                int leftSum = sums[i] - nums[i];
                int rightSum = sum - sums[i];
                if (leftSum == rightSum) return i;
            }
            return -1;
        }
    }
}

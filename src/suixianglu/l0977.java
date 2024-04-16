package suixianglu;

public class l0977 {

    // 遍历 + 双指针: O(n + n)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int mid = -1;
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 == nums.length) mid = i;
                else {
                    // < 而不是<=
                    if (Math.abs(nums[i]) < Math.abs(nums[i + 1])) {
                        mid = i;
                        break;
                    }
                }
            }

            int left = mid, right = mid + 1;
            int[] result = new int[nums.length];
            int index = 0;
            while (left >= 0 && right < nums.length) {
                int leftPow = nums[left] * nums[left];
                int rightPow = nums[right] * nums[right];
                if (leftPow <= rightPow) {
                    result[index++] = leftPow;
                    left--;
                } else {
                    result[index++] = rightPow;
                    right++;
                }
            }

            if (right == nums.length) {
                while (left >= 0) {
                    result[index++] = nums[left] * nums[left];
                    left--;
                }
            } else {
                while (right < nums.length) {
                    result[index++] = nums[right] * nums[right];
                    right++;
                }
            }

            return result;
        }
    }

    // 二分 + 双指针: O(log(n) + n)
}

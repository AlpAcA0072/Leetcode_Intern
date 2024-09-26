package suixianglu;

public class l0169 {
    // 此方法错误！！！！
    class Solution {
        public int majorityElement(int[] nums) {
            long total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
            }
            double ave = (double) total / nums.length;
            double minus = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (minus > Math.abs(nums[i] - ave)) {
                    minus = Math.abs(nums[i] - ave);
                    result = nums[i];
                }
            }
            return result;
        }
    }

    // 要求时间复杂度为 O(n)、空间复杂度为 O(1)
    // 出现次数 大于 ⌊ n/2 ⌋
    // 和Boyer-Moore 投票算法思路比较接近，但是该方法还是不对
    class Solution2 {
        public int majorityElement(int[] nums) {
            if (nums.length == 1) return nums[0];

            int count1 = 1;
            int count2 = 0;
            int value1 = nums[0];
            int value2 = nums[1];

            for (int i = 2; i < nums.length; i++) {
                int curr = nums[i];
                if (value1 == curr) {
                    count1++;
                } else if (value2 == curr) {

                }
            }
            return count1;
        }
    }
}

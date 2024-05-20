package suixianglu.greedy.L;

public class l0376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1) return nums.length;
            int flag = nums[1] - nums[0];
            int len = 1;
            int i = 2;
            if (flag == 0) {
                while (i < nums.length && nums[i] - nums[i - 1] == 0) i++;
                if (i == nums.length) return 1;
                flag = nums[i] - nums[i - 1];
            }
            len++;
            for (; i < nums.length; i++) {
                if ((nums[i] - nums[i - 1]) * flag < 0) {
                    len++;
                    flag = nums[i] - nums[i - 1];
                }
            }

            return len;
        }
    }
}

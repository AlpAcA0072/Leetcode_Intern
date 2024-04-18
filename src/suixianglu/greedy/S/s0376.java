package suixianglu.greedy.S;

public class s0376 {
    // dp
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int up = 1, down = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                } else if (nums[i] < nums[i - 1]) {
                    down = up + 1;
                }
            }
            return Math.max(up, down);
        }
    }

    // greedy
    class Solution2 {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int prevdiff = nums[1] - nums[0];
            int ret = prevdiff != 0 ? 2 : 1;
            for (int i = 2; i < n; i++) {
                int diff = nums[i] - nums[i - 1];
                if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                    ret++;
                    prevdiff = diff;
                }
            }
            return ret;
        }
    }
}

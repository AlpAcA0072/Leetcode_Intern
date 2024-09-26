package suixianglu;

public class l0209 {
    public static void main(String[] args) {
        l0209 l0209 = new l0209();
//        Solution solution = l0209.new Solution();
//        int result = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
//        System.out.println(result);
        Solution2 solution2 = l0209.new Solution2();
        int result = solution2.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5});
        System.out.println(result);
    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minLen = Integer.MAX_VALUE;
            int st = 0, end = 0;
            int sum = 0;
            if (nums.length == 0) return nums.length;

            while (end < nums.length) {
                // 这里没有对 end 的 while 循环。
                // 从而避免考虑 end 的边界情况。
                sum += nums[end];
                while (sum >= target) {
                    minLen = Math.min(minLen, end - st + 1);
                    sum -= nums[st];
                    st++;
                }
                end++;
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }

    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int l = 0;
            int r = 0;
            int minLen = Integer.MAX_VALUE;
            int sum = nums[0];
            while (true) {
                if (sum >= target) {
                    int currLen = r - l + 1;
                    while (sum >= target && l <= r) {
                        sum -= nums[l];
                        l++;
                        currLen--;
                    }
                    minLen = Math.min(minLen, currLen + 1);
                }
                r++;
                if (r < nums.length)
                    sum += nums[r];
                else break;
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}

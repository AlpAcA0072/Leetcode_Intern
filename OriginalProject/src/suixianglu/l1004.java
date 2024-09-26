package suixianglu;

public class l1004 {
    public static void main(String[] args) {
        l1004 l1004 = new l1004();
        Solution s = l1004.new Solution();
        s.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }

    class Solution {
        public int longestOnes(int[] nums, int k) {
            int l = 0;
            int count0 = 0;
            int r;
            for (r = 0; r < nums.length && count0 < k; r++) {
                count0 += nums[r] == 0 ? 1 : 0;
            }
            if (count0 != k) return nums.length;
            int maxLen = r - l;
            while (r < nums.length) {
                if (nums[r] == 0) {
                    count0++;
                    while (count0 != k) {
                        count0 -= nums[l] == 0 ? 1 : 0;
                        l++;
                    }
                }
                r++;
                maxLen = Math.max(maxLen, r - l);
            }
            return maxLen;
        }
    }
}

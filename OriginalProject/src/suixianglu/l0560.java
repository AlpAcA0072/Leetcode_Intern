package suixianglu;

public class l0560 {
    public static void main(String[] args) {
        l0560 l = new l0560();
        Solution s = l.new Solution();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] leftSum = new int[nums.length + 1];
            int currSum = 0;
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                leftSum[i + 1] = currSum;
            }

            int l;
            int count = 0;
            // (l, r]
            for (int r = 1; r < leftSum.length; r++) {
                l = 0;
                currSum = leftSum[r];
                while (l <= r - 1) {
                    if (currSum - leftSum[l] == k) count++;
                    l++;
                }
            }
            return count;
        }
    }
}

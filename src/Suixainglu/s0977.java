package Suixainglu;

public class s0977 {
    class Solution {
        // 使用两个指针分别指向位置 000 和 n−1n-1n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    ans[pos] = nums[i] * nums[i];
                    ++i;
                } else {
                    ans[pos] = nums[j] * nums[j];
                    --j;
                }
                --pos;
            }
            return ans;
        }
    }
}

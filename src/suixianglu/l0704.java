package suixianglu;

public class l0704 {
    class Solution {
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            // start <= end 而不是 start < end
            // 为了排除start == end 的情况
            while (start <= end) {
                int mid = (start + end) / 2;
                int midValue = nums[mid];
                if (midValue == target) return mid;
                else if (midValue > target) {
                    end = mid - 1;
                } else start = mid + 1;
            }

            return -1;
        }
    }
}

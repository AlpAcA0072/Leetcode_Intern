package suixianglu.array;

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

    class Solution2 {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < target) {
                    l = mid + 1;
                } else r = mid;
            }
            if (nums[r] == target) return r;
            else return -1;
        }
    }
}

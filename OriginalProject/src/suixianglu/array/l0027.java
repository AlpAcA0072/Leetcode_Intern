package suixianglu;

public class l0027 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int newEnd = -1;
            int ptr = 0;
            while (ptr < nums.length) {
                if (nums[ptr] != val) {
                    if (newEnd == ptr - 1) {
                        ptr++;
                        newEnd++;
                    } else {
                        nums[++newEnd] = nums[ptr++];
                    }
                } else {
                    ptr++;
                }
            }

            return newEnd + 1;
        }
    }

    // Solution1的优化
    class Solution2 {
        public int removeElement(int[] nums, int val) {
            int newEnd = -1;
            int ptr = 0;
            while (ptr < nums.length) {
                if (nums[ptr] != val) {
                    if (newEnd == ptr - 1) newEnd++;
                    else nums[++newEnd] = nums[ptr];
                }
                ptr++;
            }

            return newEnd + 1;
        }
    }
}

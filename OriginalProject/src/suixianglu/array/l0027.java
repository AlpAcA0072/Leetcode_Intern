package suixianglu.array;

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

    class Solution3 {
        public int removeElement(int[] nums, int val) {
            int ptr = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[ptr++] = nums[i];
                }
            }
            return ptr;
        }
    }
}

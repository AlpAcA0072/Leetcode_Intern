package LeetcodeHot100;

public class l0026 {
    // same as the standard solution.
    class Solution {
        public int removeDuplicates(int[] nums) {
            int counter = 1;
            int index = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i-1]) {
                    counter++;
                    nums[index++] = nums[i];
                }
            }

            return counter;
        }
    }
}

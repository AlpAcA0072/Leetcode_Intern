package LeetcodeHot100;

public class s0026 {
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

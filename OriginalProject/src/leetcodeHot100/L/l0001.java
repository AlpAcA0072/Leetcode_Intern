package leetcodeHot100.L;

import java.util.HashMap;

public class l0001 {
    // same as the standard solution
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(target - nums[i])) {
                    return new int[]{i, hashMap.get(target - nums[i])};
                }
                hashMap.put(nums[i], i);
            }
            return new int[0];
        }
    }
}

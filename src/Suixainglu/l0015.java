package Suixainglu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l0015 {
    public static void main(String[] args) {
        l0015 l0015 = new l0015();
        Solution solution = l0015.new Solution();
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{1, -1, -1, 0};
        System.out.println(solution.threeSum(nums));
    }

    class Solution {
        // 待完成
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> re = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int valueI = nums[i];
                int k = nums.length - 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;


                    // key code: 终止条件 nums[j] + nums[k] + valueI <= 0
                    while (j < k && nums[j] + nums[k] + valueI > 0) {
                        --k;
                    }
                    if (j == k) break;
                    // key code

                    if (nums[j] + nums[k] + valueI == 0) {
                        List<Integer> arr = new ArrayList<>();
                        arr.add(valueI);
                        arr.add(nums[j]);
                        arr.add(nums[k]);
                        re.add(arr);
                    }
                }
            }

            return re;
        }
    }
}

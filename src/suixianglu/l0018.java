package suixianglu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l0018 {
    public static void main(String[] args) {
        l0018 l0018 = new l0018();
        suixianglu.l0018.Solution solution = l0018.new Solution();
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(solution.fourSum(nums, -294967296));
    }

    // 这道题沿用了三数之和的思路: 外围限制first(从左到右)和second(从右到左), third和forth在first和second之间移动, third < forth.
    // TODO: 时间复杂度, O(n^3) or O(n^2)?
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);

            List<List<Integer>> re = new ArrayList<>();

            for (int first = 0; first < nums.length; first++) {
                if (first > 0 && nums[first] == nums[first - 1]) continue;
                int valueFirst = nums[first];
                for (int second = nums.length - 1; second > 0; second--) {
                    if (second < nums.length - 1 && nums[second] == nums[second + 1]) continue;

                    if (first == second) break;

                    int forth = second - 1;
                    int valueSecond = nums[second];
                    for (int third = first + 1; third < second; third++) {
                        if (third > first + 1 && nums[third] == nums[third - 1]) continue;


                        while (third < forth && (long) nums[third] + nums[forth] + valueFirst + valueSecond > target) {
                            --forth;
                        }
                        if (third == forth) break;

                        if ((long) nums[third] + nums[forth] + valueFirst + valueSecond == target) {
                            List<Integer> arr = new ArrayList<>();
                            arr.add(valueFirst);
                            arr.add(valueSecond);
                            arr.add(nums[third]);
                            arr.add(nums[forth]);
                            re.add(arr);
                        }
                    }
                }
            }

            return re;
        }
    }
}

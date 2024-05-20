package suixianglu;

import java.util.ArrayList;
import java.util.List;

public class l0349 {
    // 注意，这道题不用考虑输出结果的顺序，所以是简单题。
    class Solution {
        // 因为题目限定数字大小范围在[1,1e3]，所以可以用此方法
        // 这个解法非常不优雅
        public int[] intersection(int[] nums1, int[] nums2) {
            int[] arr = new int[1001];
            for (int i : nums1) {
                arr[i]++;
            }

            List<Integer> result = new ArrayList<>();
            for (int i : nums2) {
                if (arr[i] > 0) {
                    arr[i] = 0;
                    result.add(i);
                }
            }

            int[] rRe = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                rRe[i] = result.get(i);
            }

            return rRe;
        }
    }
}

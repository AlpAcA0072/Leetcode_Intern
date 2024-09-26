package suixianglu;

public class s0169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            if (candidate != null) {
                return candidate;
            }else throw new NullPointerException();
        }
    }
}

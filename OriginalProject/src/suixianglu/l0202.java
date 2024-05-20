package suixianglu;

import java.util.HashMap;
import java.util.Map;

public class l0202 {

    // Brute force
    // 该题不需要用HashMap, HashSet即可。
    class Solution {
        public boolean isHappy(int n) {
            Map<Long, Integer> map = new HashMap<>();
            long num = n;
            long result = 0;
            while (result != 1) {
                result = 0;
                while (num != 0) {
                    long digit = num % 10;
                    num = num / 10;
                    result += digit * digit;
                }
                if (map.containsKey(result)) return false;
                else map.put(result, 1);

                num = result;
            }

            return true;
        }
    }
}

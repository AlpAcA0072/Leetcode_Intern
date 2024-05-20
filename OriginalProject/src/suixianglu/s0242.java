package suixianglu;

import java.util.Arrays;

public class s0242 {
    class Solution {
        // 字符串排序 O(N * log (N))
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);
        }
    }
}

package suixianglu;

import java.util.HashMap;
import java.util.Map;

public class l0003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Integer, Character> map = new HashMap<>();
            int longLen = 0;
            int l = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsValue(c)) {
                    longLen = Math.max(map.size(), longLen);
                    for (; ; ) {
                        if (map.get(l) == c) {
                            map.remove(l);
                            l++;
                            break;
                        }
                        map.remove(l);
                        l++;
                    }
                }
                map.put(i, c);
            }
            return Math.max(longLen, map.size());
        }
    }
}

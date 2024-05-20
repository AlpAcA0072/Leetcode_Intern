package suixianglu;

import java.util.HashMap;
import java.util.Map;

public class l0242 {

    // 内存和时间开销太大
    // solution1 和 solution2是等价的
    // 在判断s的长度等于t的长度之后
    // 就不用删除map中的元素了，因为如果两者不是字母异位词，map中就一定存在小于0的元素。
    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();

            Map<Character, Integer> map = new HashMap<>();

            for (char c : s1) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char c : s2) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == -1) return false;
                if (map.get(c) == 0) map.remove(c);
            }

            return map.isEmpty();
        }
    }

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;


            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == -1) return false;
            }

            return true;
        }
    }
}

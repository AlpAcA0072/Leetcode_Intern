import java.util.*;

public class l0049 {
    class Solution {

        // Sort
        // max length of word: l, number of words: n
        // Time: O(n * l * log(l))
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String key = Arrays.toString(arr);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }

            return new ArrayList<List<String>>(map.values());
        }
    }

    class Solution2 {

        // Count numbers in word
        // max length of word: l, number of words: n
        // Time: O(n * l)
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] arr = str.toCharArray();
                Map<Character, Integer> count = new HashMap<>();
                for (char c : arr) {
                    int n = count.getOrDefault(c, 0) + 1;
                    count.put(c, n);
                }
                List<String> list = map.getOrDefault(count, new ArrayList<String>());
                list.add(str);
                map.put(count, list);
            }

            return new ArrayList<List<String>>(map.values());
        }
    }
}

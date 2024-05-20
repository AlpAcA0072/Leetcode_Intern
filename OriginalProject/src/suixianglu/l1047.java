package suixianglu;

import java.util.ArrayDeque;
import java.util.Deque;

public class l1047 {
    class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> chars = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (chars.peek() == Character.valueOf(c)) {
                    chars.pop();
                } else chars.push(c);
            }

            StringBuilder sb = new StringBuilder();
            while (!chars.isEmpty()) {
                sb.insert(0, chars.pop());
            }

            return sb.toString();
        }
    }

    class Solution2 {
        public String removeDuplicates(String s) {
            StringBuilder sb = new StringBuilder();

            for (Character c : s.toCharArray()) {
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c) {
                    sb.deleteCharAt(sb.length() - 1);
                } else sb.append(c);
            }
            return sb.toString();
        }
    }

}

package suixianglu;

public class s1047 {
    class Solution {
        public String removeDuplicates(String s) {
            StringBuilder stack = new StringBuilder();
            int top = -1;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (top >= 0 && stack.charAt(top) == ch) {
                    stack.deleteCharAt(top);
                    --top;
                } else {
                    stack.append(ch);
                    ++top;
                }
            }
            return stack.toString();
        }
    }
}

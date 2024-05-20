package leetcodeHot100.L;

import java.util.*;

public class l0394 {
    public static void main(String[] args) {
        l0394 l0394 = new l0394();
        Solution s = l0394.new Solution();
        String str = s.decodeString("abc3[cd]xyz");
        System.out.println(str.equals("abcabccdcdcdef"));
        System.out.println(str);
    }

    class Solution {
        public String decodeString(String s) {
            char[] chars = s.toCharArray();
            Deque<String> stack = new ArrayDeque<>();
            int k = 0;
            // 数字一定以'['结束
            // 字符以']'或者下一个数字结束，也有可能在字符串末尾。
            for (char c : chars) {
                if (c <= '9' && c >= '0') {
                    k = k * 10 + (c - '0');
                } else if (c == '[') {
                    stack.addLast(String.valueOf(k));
                    k = 0;
                    stack.addLast(String.valueOf(c));
                } else if (c == ']') {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (!stack.isEmpty() && !stack.peekLast().equals("[")) {
                        stringBuilder.insert(0, stack.removeLast());
                    }
                    stack.removeLast();
                    int num = Integer.parseInt(stack.removeLast());
                    stack.addLast(stringBuilder.toString().repeat(num));
                } else {
                    stack.addLast(String.valueOf(c));
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.removeFirst());
            }

            return sb.toString();
        }
    }
}

package leetcodeHot100.S;

import java.util.*;

public class s0394 {
    class Solution {
        int ptr;

        public String decodeString(String s) {
            LinkedList<String> stk = new LinkedList<String>();
            ptr = 0;

            while (ptr < s.length()) {
                char cur = s.charAt(ptr);
                if (Character.isDigit(cur)) {
                    // 获取一个数字并进栈
                    String digits = getDigits(s);
                    stk.addLast(digits);
                } else if (Character.isLetter(cur) || cur == '[') {
                    // 获取一个字母并进栈
                    stk.addLast(String.valueOf(s.charAt(ptr++)));
                } else {
                    ++ptr;
                    LinkedList<String> sub = new LinkedList<String>();
                    while (!"[".equals(stk.peekLast())) {
                        sub.addLast(stk.removeLast());
                    }
                    Collections.reverse(sub);
                    // 左括号出栈
                    stk.removeLast();
                    // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                    int repTime = Integer.parseInt(stk.removeLast());
                    StringBuffer t = new StringBuffer();
                    String o = getString(sub);
                    // 构造字符串
                    while (repTime-- > 0) {
                        t.append(o);
                    }
                    // 将构造好的字符串入栈
                    stk.addLast(t.toString());
                }
            }

            return getString(stk);
        }

        public String getDigits(String s) {
            StringBuffer ret = new StringBuffer();
            while (Character.isDigit(s.charAt(ptr))) {
                ret.append(s.charAt(ptr++));
            }
            return ret.toString();
        }

        public String getString(LinkedList<String> v) {
            StringBuffer ret = new StringBuffer();
            for (String s : v) {
                ret.append(s);
            }
            return ret.toString();
        }
    }


    class Solution2 {
        String src;
        int ptr;

        public String decodeString(String s) {
            src = s;
            ptr = 0;
            return getString();
        }

        public String getString() {
            if (ptr == src.length() || src.charAt(ptr) == ']') {
                // String -> EPS
                return "";
            }

            char cur = src.charAt(ptr);
            int repTime = 1;
            String ret = "";

            if (Character.isDigit(cur)) {
                // String -> Digits [ String ] String
                // 解析 Digits
                repTime = getDigits();
                // 过滤左括号
                ++ptr;
                // 解析 String
                String str = getString();
                // 过滤右括号
                ++ptr;
                // 构造字符串
                while (repTime-- > 0) {
                    ret += str;
                }
            } else if (Character.isLetter(cur)) {
                // String -> Char String
                // 解析 Char
                ret = String.valueOf(src.charAt(ptr++));
            }

            return ret + getString();
        }

        public int getDigits() {
            int ret = 0;
            while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
                ret = ret * 10 + src.charAt(ptr++) - '0';
            }
            return ret;
        }
    }
}

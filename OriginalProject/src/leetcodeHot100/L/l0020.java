package leetcodeHot100.L;

import java.util.Stack;

public class l0020 {
    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArr) {
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty())
                    return false;
                else if (!(stack.pop() == '{'))
                    return false;
            } else if (c == ']') {
                if (stack.isEmpty())
                    return false;
                else if (!(stack.pop() == '['))
                    return false;
            } else if (c == ')') {
                if (stack.isEmpty())
                    return false;
                else if (!(stack.pop() == '('))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
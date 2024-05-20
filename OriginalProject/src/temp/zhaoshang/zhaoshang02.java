package temp.zhaoshang;

import java.util.Scanner;
import java.util.Stack;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class zhaoshang02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            if (ifSuccess(str.substring(begin, end + 1))) {
                sb.append('Y');
            } else sb.append('N');
        }
        System.out.println(sb);

    }

    private static boolean ifSuccess(String str) {
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.peek() == c) {
                stack.pop();
            } else stack.push(c);
        }
        if (stack.size() == 1) {
            return stack.peek() == 'R';
        }

        if (stack.size() >= 6) return false;
        if (stack.size() == 3 || stack.size() == 4) {
            while (!stack.isEmpty()) {
                if (stack.pop() == 'R') return true;
            }
            return false;
        }
        if (stack.size() == 5) {
            for (int i = 1; i <= 5; i++) {
                char c = stack.pop();
                if (i == 1 || i == 3 || i == 5) {
                    if (c == 'R') return true;
                }
            }
            return false;
        }

        return false;
    }
}
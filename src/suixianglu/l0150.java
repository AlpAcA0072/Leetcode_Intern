package suixianglu;

import java.util.ArrayDeque;
import java.util.Deque;

public class l0150 {
    public static void main(String[] args) {
        l0150 l0150 = new l0150();
        Solution solution = l0150.new Solution();
        String[] arr = new String[]{"4", "13", "5", "/", "+"};
        solution.evalRPN(arr);
    }

    // 逆波兰表达式, 适合用栈操作运算: 遇到数字则入栈; 遇到算符则取出栈顶两个数字进行计算, 并将结果压入栈中
    class Solution {
        public int evalRPN(String[] tokens) {
            int num1, num2;
            Deque<Integer> numbers = new ArrayDeque<>();
            for (String s : tokens) {
                if (!s.matches("^[+\\-*/]$")) {
                    numbers.push(Integer.parseInt(s));
                } else {
                    num1 = numbers.pop();
                    num2 = numbers.pop();
                    switch (s) {
                        case "+":
                            num2 += num1;
                            break;
                        case "-":
                            num2 -= num1;
                            break;
                        case "*":
                            num2 *= num1;
                            break;
                        case "/":
                            num2 /= num1;
                            break;
                    }
                    numbers.push(num2);

                }
            }

            return numbers.pop();
        }
    }

    // 正则表达式比手写的匹配要慢
    class Solution2 {
        public int evalRPN(String[] tokens) {
            int num1;
            Deque<Integer> numbers = new ArrayDeque<>();
            for (String s : tokens) {
                if (s.matches("^[+\\-*/]$")) {
                    num1 = numbers.pop();
                    switch (s) {
                        case "+":
                            numbers.push(numbers.pop() + num1);
                            break;
                        case "-":
                            numbers.push(numbers.pop() - num1);
                            break;
                        case "*":
                            numbers.push(numbers.pop() * num1);
                            break;
                        case "/":
                            numbers.push(numbers.pop() / num1);
                            break;
                        default:
                    }
                } else {
                    numbers.push(Integer.parseInt(s));
                }
            }

            return numbers.pop();
        }
    }
}

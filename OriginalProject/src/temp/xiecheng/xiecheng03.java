package temp.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class xiecheng03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        List<Integer> result = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();

        generate(result, digits, new ArrayList<>(), m);

        int count = 0;
        for (int num : result) {
            if (num > k) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void generate(List<Integer> result, List<Integer> digits, List<Integer> curr, int m) {
        if (curr.size() == m) {
            int number = 0;
            for (int i = 0; i < curr.size(); i++) {
                number = number * 10 + curr.get(i);
            }
            result.add(number);
            return;
        }
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            if (curr.isEmpty() && digit == 0 && m > 1) {
                continue;
            }

            List<Integer> newDigits = new ArrayList<>(digits);
            newDigits.remove(i);

            curr.add(digit);
            generate(result, newDigits, curr, m);

            curr.remove(curr.size() - 1);
        }
    }
}
package temp;

import java.util.Scanner;

//100/100

public class meituan02 {
    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();

        long maxSum = Integer.MIN_VALUE;
        long mod = 10;
        int flag = num > 0 ? 1 : -1;
        num = Math.abs(num);
        do {
            mod = mod * 10;
        } while (num / mod != 0);
        long firstPart, secondPart;
        if (flag < 0) {
            firstPart = (num / (mod / 10)) * -1;
            secondPart = (num % (mod / 10));
        } else {
            firstPart = (num / 10);
            secondPart = (num % 10);
        }
        maxSum = firstPart + secondPart;

        System.out.print(maxSum);
    }
}

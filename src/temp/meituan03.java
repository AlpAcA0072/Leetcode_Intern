package temp;

import java.util.Scanner;

//100/100

public class meituan03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt(), k = in.nextInt();
            char[] s = in.next().trim().toCharArray(),
                    t = in.next().trim().toCharArray();
            int count = 0;
            for (int j = 0; j < n; j++) {
                char sc = s[j];
                char tc = t[j];
                int operations;
                if (tc >= sc) {
                    operations = tc - sc;
                } else {
                    operations = tc + 26 - sc;
                }
                count += operations;
            }
            if (count == k) {
                System.out.println("Yes");
            } else if (k > count && (k - count) % 26 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

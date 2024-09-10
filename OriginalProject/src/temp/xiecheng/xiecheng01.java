package temp.xiecheng;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class xiecheng01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            for (int i = 1; i < b; i++) {
                System.out.print(i);
                System.out.print(" ");
            }
            for (int i = a; i >= b; i--) {
                System.out.print(i);
                if (i != 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
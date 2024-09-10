package temp.xiecheng;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class xiecheng02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int len = in.nextInt();
            in.nextLine();
            String string = in.nextLine();
            char[] str = new char[string.length()];
            for (int i = 0; i < string.length(); i++) {
                str[i] = string.charAt(i);
            }
            if (len == 1) {
                if (str[0] == '0') {
                    System.out.print(1);
                } else System.out.print(0);
            } else {
                int result = 0;
                for (int i = 1; i <= len; i += 2) {
                    // i是长度
                    int count = 1;
                    int[] arr = new int[i];
                    char valid = '0';
                    for (int j = 0; j + i < len; j++) {
                        // j是开始位置
                        for (int k = 0; k < i + 1; k++) {
                            if (str[k + j] == valid) {
                                arr[k + j] = count++;
                                if (valid == '0') valid = '1';
                                else valid = '0';
                            }
                        }
                        if ((arr[arr.length - 1]) % 2 == 1) result++;
                    }
                }
//                int count = 1;
//                int[] arr = new int[len];
//                char valid = '0';
//                for (int i = 0; i < len; i++) {
//                    if (str[i] == valid) {
//                        arr[i] = count++;
//                        if (valid == '0') valid = '1';
//                        else valid = '0';
//                    }
//                }
//
//                int result = 0;
//                for (int i = 0; i < len; i += 2) {
//                    // i是长度
//                    for (int j = 0; j + i < len; j++) {
//                        // j是开始位置
//                        if ((arr[j + i]) % 2 == 1) result++;
//                    }
//                }
//                System.out.print(result);
            }
        }
    }
}
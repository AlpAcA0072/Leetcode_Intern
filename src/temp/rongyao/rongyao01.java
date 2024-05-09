package temp.rongyao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class rongyao01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        String[] arr = s.split("\\.");
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = Integer.parseInt(arr[i]);
        }

        BigInteger result = new BigInteger("0");
        for (int i = 0; i < arr.length; i++) {
            long curr = ints[i];
            for (int j = 0; j < arr.length - i - 1; j++) {
                curr *= 256;
            }
            result = result.add(BigInteger.valueOf(curr));
        }

        System.out.println(result);
    }
}
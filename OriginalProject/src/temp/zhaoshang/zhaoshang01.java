package temp.zhaoshang;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class zhaoshang01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(in.next());

            int minDepth = Integer.MAX_VALUE;
            int index = sb.toString().indexOf("BRR");
            if (index != -1) {
                minDepth = index;
            }
            index = sb.toString().indexOf("BRB");
            if (index != -1) {
                minDepth = Math.min(minDepth, index + 1);
            }
            index = sb.toString().indexOf("RRR");
            if (index != -1) {
                minDepth = Math.min(minDepth, index + 1);
            }
            index = sb.toString().indexOf("RRB");
            if (index != -1) {
                minDepth = Math.min(minDepth, index + 2);
            }

            if (minDepth == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(minDepth);
        }
    }
}
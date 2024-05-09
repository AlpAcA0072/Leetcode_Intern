package temp.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class huawei01 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        8 2 1 3 7 5 6 4 6
        // 2 1 2
        // 2 1 1

        Scanner in = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            arr.add(in.nextInt());
//        }
        while (in.hasNext()) {
            arr.add(in.nextInt());
        }
        int query = arr.remove(arr.size() - 1);

        Collections.sort(arr);
        int left = 1, right = arr.size();
        int mid = (left + right + 1) / 2;
        StringBuilder sb = new StringBuilder();
        if (right == 0) {
            System.out.println("N");
        } else if (arr.get(mid - 1) == query) {
            System.out.println("Y");
        } else if (arr.get(mid - 1) != query && left == right) {
            System.out.println("N");
        } else {
            sb.append("S");
            while (arr.get(mid - 1) != query && left != right) {
                if (arr.get(mid - 1) < query) {
                    sb.append("R");
                    left = mid + 1;
                } else {
                    sb.append("L");
                    right = mid - 1;
                }
                mid = (left + right) / 2;
            }

            if (arr.get(mid - 1) == query) {
                sb.append("Y");
            } else sb.append("N");
            System.out.println(sb);
        }
    }
}


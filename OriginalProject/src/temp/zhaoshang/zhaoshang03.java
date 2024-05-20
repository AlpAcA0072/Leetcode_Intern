package temp.zhaoshang;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class zhaoshang03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int S = in.nextInt();
        int R = in.nextInt();
        int K = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] arr = new int[N][3];
        for (int i = 0; i < M; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
        }

        for (int[] ints : arr) {
            if (ints[0] > S) {
                if (ints[2] <= R) {
                    map.put(ints[0], map.getOrDefault(ints[0], 0) + 1);
                }
            } else if (ints[1] > S) {
                if (ints[2] <= R) {
                    map.put(ints[1], map.getOrDefault(ints[1], 0) + 1);
                }
            }
        }

        ArrayList<Integer> arr2 = new ArrayList<>();
        for (Integer i : map.keySet()) {
            int value = map.get(i);
            if (value >= K) {
                arr2.add(i);
            }
        }

        Collections.sort(arr2);
        System.out.println(arr2.size());
        for (Integer integer : arr2) {
            System.out.println(integer);
        }
    }
}
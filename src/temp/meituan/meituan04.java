package temp.meituan;

import java.util.*;

//0/100

public class meituan04 {
    // map: <currVal, currCount>
    static Map<Long, Long> map = new HashMap();
    static long count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] vals = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            vals[i] = in.nextInt();
        }
        int[][] connections = new int[n + 1][n + 1];
        for (int i = 1; i <= n - 1; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            connections[node1][node2] = 1;
            connections[node2][node1] = 1;
        }
        List<Integer> route = new ArrayList<>();
        map.put(1L, 1L);
        DFSRecursive(1, 1, vals, connections, route);
        System.out.print((int)count);
    }


    // 前缀和
    private static void DFSRecursive(int node, long currVal, int[] vals, int[][] conns, List<Integer> route) {

        int val = vals[node];
        currVal *= val;
        route.add(node);
        for (Long l : map.keySet()) {
            if (Math.sqrt((double) (currVal / l)) % 1 == 0 && route.size() != 1) {
                // is
                count += map.getOrDefault(l, 0L);
            }
        }


        // key = currVal, val = currCount
        map.put(currVal, map.getOrDefault(currVal, 0L) + 1);
        for (int i = 1; i < conns.length; i++) {
            if (conns[node][i] == 1 && !route.contains(i)) {
                DFSRecursive(i, currVal, vals, conns, route);
            }
        }
        route.remove(route.size() - 1);
        map.put(currVal, map.getOrDefault(currVal, 0L) - 1);
    }
}

/**
 5
 1 2 2 2 2
 1 2
 2 3
 3 4
 4 5

 6
 */

/**
 3
 1 1 1
 1 2
 2 3

 3
 */

/**
 4
 2 2 2 2
 1 2
 2 3
 3 4

 4
 */
//package temp.jingdong;
//
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class jingdong03 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int k = in.nextInt();
//            int sum_limit = in.nextInt();
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            for (int j = 1; j <= n; j++) {
//                pq.add(j);
//            }
//           int result =  count(k, sum_limit, pq);
//        }
//    }
//
//    private static long sum(PriorityQueue<Integer> arr){
//        arr.
//    }
//
//
//    private  static int count(int k, int sum_limit, PriorityQueue<Integer> arr){
//        int  count = 0;
//
//        while sum(arr[-k:]) > sum_limit:
//        top = heapq.heappop(arr)
//        top -= 1
//        heapq.heappush(arr, top)
//        count += 1
//        return count
//    }
//}

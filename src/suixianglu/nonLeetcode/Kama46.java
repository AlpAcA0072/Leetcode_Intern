package suixianglu.nonLeetcode;

import java.util.Scanner;

class Kama46 {
    // 0/1 backpack
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[] weight = new int[M];
        int[] value = new int[M];
        for (int i = 0; i < M; i++) {
            weight[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            value[i] = in.nextInt();
        }

        // dp
        // dp[i][j] 从下标为[0, i]的物品里任意取，放进容量为j的背包，最大价值是多少
        int[][] dp = new int[M][N + 1];

        for (int j = weight[0]; j <= N; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[M - 1][N]);
    }
}


// 滚动数组优化
class Kama46_2 {
    // 0/1 backpack
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[] weight = new int[M];
        int[] value = new int[M];
        for (int i = 0; i < M; i++) {
            weight[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            value[i] = in.nextInt();
        }

        // dp
        // dp[i][j] 从下标为[0, i]的物品里任意取，放进容量为j的背包，最大价值是多少
        int[] dp = new int[N + 1];

        for (int j = weight[0]; j <= N; j++) {
            dp[j] = value[0];
        }

        for (int i = 1; i < M; i++) {
            for (int j = N; j >= 1; j--) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[N]);
    }
}
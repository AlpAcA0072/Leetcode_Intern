package suixianglu.dp.L;

public class l0096 {
    // 做法解析详见
    // https://leetcode.cn/problems/unique-binary-search-trees/solutions/329807/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution
    class Solution {
        public int numTrees(int n) {
            if (n <= 1) return 1;
            int[] g = new int[n + 1];
            g[0] = 1;
            g[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    g[i] += g[i - j] * g[j - 1];
                }
            }
            return g[n];
        }
    }
}

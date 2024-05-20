package suixianglu.dp.S;

public class s0096 {
    // dp
    // 做法解析详见
    // https://leetcode.cn/problems/unique-binary-search-trees/solutions/329807/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution
    class Solution {
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }

    class Solution2 {
        public int numTrees(int n) {
            // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
            long C = 1;
            for (int i = 0; i < n; ++i) {
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }
}

package suixianglu.dp.S;

public class s0062 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] f = new int[m][n];
            for (int i = 0; i < m; ++i) {
                f[i][0] = 1;
            }
            for (int j = 0; j < n; ++j) {
                f[0][j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
            return f[m - 1][n - 1];
        }
    }

    // space = O(n)
    class Solution2 {
        public int uniquePaths(int m, int n) {
            int[] f = new int[n];
            for (int i = 0; i < n; ++i) {
                f[i] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[j] += f[j - 1];
                }
            }
            return f[n - 1];
        }
    }

    //数学方法
    class Solution3 {
        public int uniquePaths(int m, int n) {
            long ans = 1;
            for (int x = n, y = 1; y < m; ++x, ++y) {
                ans = ans * x / y;
            }
            return (int) ans;
        }
    }
}

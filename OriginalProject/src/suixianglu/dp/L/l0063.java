package suixianglu.dp.L;

public class l0063 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            int[][] dp = new int[row][col];

            for (int i = 0; i < col; i++) {
                if (obstacleGrid[0][i] == 1) {
                    break;
                } else dp[0][i] = 1;
            }
            for (int i = 0; i < row; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                } else dp[i][0] = 1;
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }

            return dp[row - 1][col - 1];
        }
    }
}

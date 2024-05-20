package suixianglu.graph.L;

import java.util.*;

public class l0417 {
    public static void main(String[] args) {
        l0417 l0417 = new l0417();
        Solution solution = l0417.new Solution();
        solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    }

    // 1 2 3
    // 8 9 4
    // 7 6 5
    class Solution {
        // 注意到右上角和左下角一定在结果中
        List<List<Integer>> arr = new ArrayList<>();
        int row, col;
        int[][] heights;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            row = heights.length;
            col = heights[0].length;
            this.heights = heights;

            boolean[][] mountainP = new boolean[row][col];
            boolean[][] mountainA = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                // 左
                DFS(i, 0, mountainP, 1);
            }
            for (int j = 1; j < col; j++) {
                // 上除左上角
                DFS(0, j, mountainP, 1);
            }

            for (int i = row - 1; i >= 0; i--) {
                // 右
                DFS(i, col - 1, mountainA, -1);
            }
            for (int j = col - 1; j >= 0; j--) {
                // 下除右下角
                DFS(row - 1, j, mountainA, -1);
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mountainA[i][j] && mountainP[i][j]) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        arr.add(list);
                    }
                }
            }
            return arr;
        }

        private void DFS(int i, int j, boolean[][] m, int direction) {
            if (i < 0 || j < 0 || i >= row || j >= col) return;

            if (m[i][j]) return;
            m[i][j] = true;

            if (ifNotNearBound(i, direction, row) && heights[i + direction][j] >= heights[i][j]) {
                DFS(i + direction, j, m, direction);
            }
            if (ifNotNearBound(i, -direction, row) && heights[i - direction][j] >= heights[i][j]) {
                DFS(i - direction, j, m, direction);
            }

            if (ifNotNearBound(j, direction, col) && heights[i][j + direction] >= heights[i][j]) {
                DFS(i, j + direction, m, direction);
            }
            if (ifNotNearBound(j, -direction, col) && heights[i][j - direction] >= heights[i][j]) {
                DFS(i, j - direction, m, direction);
            }
        }

        private boolean ifNotNearBound(int i, int direction, int bound) {
            return i + direction != bound && i + direction != -1;
        }
    }
}

package suixianglu.graph.L;

import java.util.ArrayDeque;
import java.util.Deque;

public class l1020 {
    class Solution {
        int row, col;
        private Deque<int[]> deque = new ArrayDeque<>();

        public int numEnclaves(int[][] grid) {
            row = grid.length;
            col = grid[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && grid[i][j] == 1) {
                        grid[i][j] = 0;
                        deque.addLast(new int[]{i, j});
                        BFS(grid);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void BFS(int[][] grid) {
            int size = deque.size();
            if (size == 0) return;
            for (int index = 0; index < size; index++) {
                int[] arr = deque.removeFirst();
                int i = arr[0];
                int j = arr[1];
                // left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    deque.addLast(new int[]{i, j - 1});
                    grid[i][j - 1] = 0;
                }
                // right
                if (j + 1 < col && grid[i][j + 1] == 1) {
                    deque.addLast(new int[]{i, j + 1});
                    grid[i][j + 1] = 0;
                }
                // up
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    deque.addLast(new int[]{i - 1, j});
                    grid[i - 1][j] = 0;
                }
                // down
                if (i + 1 < row && grid[i + 1][j] == 1) {
                    deque.addLast(new int[]{i + 1, j});
                    grid[i + 1][j] = 0;
                }

            }
            BFS(grid);
        }

    }
}

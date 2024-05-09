package suixianglu.graph.L;

import java.util.ArrayDeque;
import java.util.Deque;

public class l0695 {
    public static void main(String[] args) {
        l0695 l0695 = new l0695();
        Solution solution = l0695.new Solution();
        int count = solution.maxAreaOfIsland(new int[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}});
        System.out.println(count);
    }

    class Solution {
        int row, col;

        public int maxAreaOfIsland(int[][] grid) {
            row = grid.length;
            col = grid[0].length;
            int maxArea = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        deque.addLast(new int[]{i, j});
                        area = 0;
                        BFS(grid);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            return maxArea;
        }

        private Deque<int[]> deque = new ArrayDeque<>();
        int area;

        private void BFS(int[][] grid) {
            int size = deque.size();
            area += size;
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

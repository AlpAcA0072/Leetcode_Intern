package suixianglu.graph.L;

import java.util.ArrayDeque;
import java.util.Deque;

public class l0200 {
    public static void main(String[] args) {
        l0200 l0200 = new l0200();
        Solution solution = l0200.new Solution();
        int count = solution.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        System.out.println(count);
    }

    class Solution {
        int row, col;

        public int numIslands(char[][] grid) {
            row = grid.length;
            col = grid[0].length;
            int count = 0;
            visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        count++;
                        visited[i][j] = true;
                        deque.addLast(new int[]{i, j});
                        BFS(grid);
                    }
                    visited[i][j] = true;
                }
            }

            return count;
        }

        private Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited;

        private void BFS(char[][] grid) {
            int size = deque.size();
            if (size == 0) return;
            for (int index = 0; index < size; index++) {
                int[] arr = deque.removeFirst();
                int i = arr[0];
                int j = arr[1];
                // left
                if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
                    deque.addLast(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
                // right
                if (j + 1 < col && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
                    deque.addLast(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
                // up
                if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
                    deque.addLast(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                // down
                if (i + 1 < row && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
                    deque.addLast(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }

            }
            BFS(grid);
        }
    }
}

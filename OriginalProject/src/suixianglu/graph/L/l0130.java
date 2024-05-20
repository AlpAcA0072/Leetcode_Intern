package suixianglu.graph.L;

import java.util.ArrayDeque;
import java.util.Deque;

public class l0130 {

    class Solution {
        int row, col;
        private Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] cannotRemove;

        public void solve(char[][] board) {
            row = board.length;
            col = board[0].length;
            cannotRemove = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O') {
                        cannotRemove[i][j] = true;
                        deque.addLast(new int[]{i, j});
                        BFS(board);
                    }
                }
            }

            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (board[i][j] == 'O' && !cannotRemove[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void BFS(char[][] board) {
            int size = deque.size();
            if (size == 0) return;
            for (int index = 0; index < size; index++) {
                int[] arr = deque.removeFirst();
                int i = arr[0];
                int j = arr[1];
                // left
                if (j - 1 >= 0 && board[i][j - 1] == 'O' && !cannotRemove[i][j - 1]) {
                    deque.addLast(new int[]{i, j - 1});
                    cannotRemove[i][j - 1] = true;
                }
                // right
                if (j + 1 < col && board[i][j + 1] == 'O' && !cannotRemove[i][j + 1]) {
                    deque.addLast(new int[]{i, j + 1});
                    cannotRemove[i][j + 1] = true;
                }
                // up
                if (i - 1 >= 0 && board[i - 1][j] == 'O' && !cannotRemove[i - 1][j]) {
                    deque.addLast(new int[]{i - 1, j});
                    cannotRemove[i - 1][j] = true;
                }
                // down
                if (i + 1 < row && board[i + 1][j] == 'O' && !cannotRemove[i + 1][j]) {
                    deque.addLast(new int[]{i + 1, j});
                    cannotRemove[i + 1][j] = true;
                }

            }
            BFS(board);
        }

    }
}

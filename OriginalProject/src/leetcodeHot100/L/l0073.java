package leetcodeHot100.L;

public class l0073 {
    public static void main(String[] args) {
        l0073 l0073 = new l0073();
        Solution s = l0073.new Solution();
        s.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            // == 0: 0 exists, else 0 does not exists.
            int row0_if0 = 1, col0_if0 = 1;
            int row = matrix.length;
            int col = matrix[0].length;

            for (int[] ints : matrix) {
                if (ints[0] == 0) {
                    col0_if0 = 0;
                    break;
                }
            }

            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    row0_if0 = 0;
                    break;
                }
            }


            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < row; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < col; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < row; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (col0_if0 == 0) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }

            if (row0_if0 == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[0][j] = 0;
                }
            }
        }
    }
}

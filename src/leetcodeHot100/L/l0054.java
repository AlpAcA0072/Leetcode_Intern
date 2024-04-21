package leetcodeHot100.L;

import java.util.*;

public class l0054 {
    public static void main(String[] args) {
        l0054 l0054 = new l0054();
        Solution s = l0054.new Solution();
        s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> arr = new ArrayList<>();
            int right = matrix[0].length - 1;
            int upper = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int count = 0;
            int size = matrix.length * matrix[0].length;
            outer:
            while (true) {
                for (int j = left; j <= right; j++) {
                    arr.add(matrix[upper][j]);
                    if (++count == size) break outer;
                }
                upper++;

                for (int i = upper; i <= bottom; i++) {
                    arr.add(matrix[i][right]);
                    if (++count == size) break outer;
                }
                right--;

                for (int j = right; j >= left; j--) {
                    arr.add(matrix[bottom][j]);
                    if (++count == size) break outer;
                }
                bottom--;

                for (int i = bottom; i >= upper; i--) {
                    arr.add(matrix[i][left]);
                    if (++count == size) break outer;
                }
                left++;

            }

            return arr;
        }
    }
}

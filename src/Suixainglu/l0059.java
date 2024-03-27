package Suixainglu;

public class l0059 {
    public static void main(String[] args) {
        l0059 l0059 = new l0059();
        Solution solution = l0059.new Solution();
        solution.generateMatrix(3);
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            int counter = 1;

            if (n == 1) return new int[][]{{counter}};

            int[][] arr = new int[n][n];

            int rightBound = n - 1, lowerBound = n - 1,
                    leftBound = 0, upperBound = 0;
            while (counter <= n * n) {
                for (int i = leftBound; i <= rightBound; i++) {
                    arr[upperBound][i] = counter++;
                }
                upperBound++;
                for (int i = upperBound; i <= lowerBound; i++) {
                    arr[i][rightBound] = counter++;
                }
                rightBound--;
                for (int i = rightBound; i >= leftBound; i--) {
                    arr[lowerBound][i] = counter++;
                }
                lowerBound--;
                for (int i = lowerBound; i >= upperBound; i--) {
                    arr[i][leftBound] = counter++;
                }
                leftBound++;
            }
            return arr;
        }
    }
}

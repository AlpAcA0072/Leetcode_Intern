package suixianglu;

public class l0240 {
    public static void main(String[] args) {
        l0240 l0240 = new l0240();
        Solution s = l0240.new Solution();
        s.searchMatrix(new int[][]{new int[]{1, 4}, new int[]{2, 5}}, 2);
    }

    // m * log(n)
    class Solution {
        public boolean biSearch(int[] arr, int target) {
            int lo = 0;
            int hi = arr.length - 1;
            if (arr[arr.length - 1] < target) return false;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (arr[mid] < target) {
                    lo = mid + 1;
                } else if (arr[mid] > target) hi = mid;
                else return true;
            }
            return arr[lo] == target;
        }

        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] <= target) {
                    if (biSearch(matrix[i], target)) return true;
                } else break;
            }
            return false;
        }
    }
}

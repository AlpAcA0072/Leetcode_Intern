public class l0088 {
    public static void main(String[] args) {
        l0088.Solution solution = new Solution();
        solution.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n != 0) {
                int pM = m - 1;
                int pN = n - 1;
                int pCurrent = m + n - 1;
                if (m == 0) System.arraycopy(nums2, 0, nums1, 0, n);
                else for (int i = pN; i >= 0; i--) {
                    for (int j = pM; j >= 0; j--) {
                        if (nums2[i] >= nums1[j]) {
                            break;
                        } else {
                            nums1[pCurrent--] = nums1[j];
                            pM = j - 1;
                        }
                    }
                    nums1[pCurrent--] = nums2[i];
                }
            }
        }
    }
}

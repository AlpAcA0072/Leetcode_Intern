package StdLib;

import java.sql.Time;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Solution2 s = sort.new Solution2();
//        Solution s = sort.new Solution();
        int[] arr = s.sortArray(new int[]{5, 2, 3, 1});
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }

    // 默认升序，降序类似
    // 非随机初始化pivot
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] arr, int start, int end) {
            if (start > end) return;

            int pivot = arr[start];
            int left = start, right = end;

            while (left < right) {
                // 找到第一个小于pivot的值
                // 取等号，不取等号可能会死循环/爆栈，因为会反复交换两个值，比如对于[1, 1]
                while (left != right && arr[right] >= pivot) {
                    right--;
                }
                arr[left] = arr[right];

                // 找到第一个大于pivot的值
                while (left != right && arr[left] <= pivot) {
                    left++;
                }
                arr[right] = arr[left];
            }

            // 此时left == right
            arr[left] = pivot;

            //归并
            quickSort(arr, start, left - 1);
            quickSort(arr, right + 1, end);
        }

    }

    // 默认升序，降序类似
    // 随机初始化pivot
    class Solution2 {
        Random r = new Random();

        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] arr, int start, int end) {
            if (start > end) return;
            int i = r.nextInt(end - start + 1) + start;

            int pivot = arr[i];
            // 随机选择 pivot 后，需要将这个 pivot 与数组的某一个已知位置（通常是 start 或 end）交换，然后按照标准快速排序的逻辑来进行。
            arr[i] = arr[start];
            arr[start] = pivot;
            int left = start, right = end;

            while (left < right) {
                // 找到第一个小于pivot的值
                // 取等号，不取等号可能会死循环/爆栈，因为会反复交换两个值，比如对于[1, 1]
                while (left != right && arr[right] >= pivot) {
                    right--;
                }
                arr[left] = arr[right];

                // 找到第一个大于pivot的值
                while (left != right && arr[left] <= pivot) {
                    left++;
                }
                arr[right] = arr[left];
            }

            // 此时left == right
            arr[left] = pivot;

            //归并
            quickSort(arr, start, left - 1);
            quickSort(arr, right + 1, end);
        }

    }

}

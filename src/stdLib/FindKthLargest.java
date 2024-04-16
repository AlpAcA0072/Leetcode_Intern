package stdLib;


// 使用部分快排法可以快速找到数组中前k大元素 (前k大内部无序)
// 理论最优时间复杂度O(n)，平均时间复杂度O(n * log(n))
// 前k小元素类似
public class FindKthLargest {
    private void kthLargest(int[] arr, int start, int end, int k) {
        int pivot = arr[start];
        int left = start, right = end;

        while (left != right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }

        // left和right相等
        arr[left] = pivot;

        // kth = k - 1
        // arr = [no need to sort] + [start, left - 1] + [left == right] + [right + 1, end] + [no need to sort]
        if (k - 1 < left) kthLargest(arr, start, left - 1, k);
        if (k - 1 > left) kthLargest(arr, left + 1, end, k);
    }
}

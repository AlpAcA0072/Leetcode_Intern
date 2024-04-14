package Suixainglu;

public class l0151 {
    // 输入字符串s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
    class Solution {
        // 非空间O(1)的解法
        public String reverseWords(String s) {
            String[] arr = s.trim().split(" +");
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            return sb.toString().trim();
        }
    }
}

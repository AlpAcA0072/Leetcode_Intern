package Suixainglu;

import java.util.Arrays;

public class l0541 {
    public static void main(String[] args) {
        l0541 l0541 = new l0541();
        Solution s = l0541.new Solution();

        s.reverseStr("abcdefg", 2);
    }

    class Solution {
        public String reverseStr(String s, int k) {
            char[] str = s.toCharArray();
            int begin = 0, end = k;
            while (end < str.length) {
                reverseString(str, begin, end - 1);
                begin = end + k;
                end = begin + k;
            }

            if (begin < str.length) reverseString(str, begin, str.length - 1);

            return String.valueOf(str);
        }

        public void reverseString(char[] s, int begin, int end) {
            int left = begin, right = end;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
        }
    }
}

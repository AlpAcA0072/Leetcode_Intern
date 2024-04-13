package Suixainglu;

public class l0344 {
    class Solution {
        public void reverseString(char[] s) {
            if (s.length == 0 || s.length == 1) return;

            int left = 0, right = s.length - 1;
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

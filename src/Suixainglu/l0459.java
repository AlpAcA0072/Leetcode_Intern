package Suixainglu;

import java.util.Map;

public class l0459 {
    public static void main(String[] args) {
        l0459 l0459 = new l0459();
        Solution solution = l0459.new Solution();
        solution.repeatedSubstringPattern("abcabcabc");
    }

    // KMP算法: 找到原字符串s在去掉首尾字符串t = (s + s)中的位置。(以s作为pattern, 分别去掉首尾一个字符的s + s作为query)
    // 方法的正确性证明可见于: https://leetcode.cn/problems/repeated-substring-pattern/solutions/386481/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int[] next = findNext(s);
            StringBuilder sb = new StringBuilder();
            sb.append(s).append(s);
            int index = KMP(sb.substring(1, sb.length() - 1), s, next);
            return index != -1;
        }

        int KMP(String query, String pattern, int[] next) {
            int i = 0, j = 0;
            while (i < query.length() && j < pattern.length()) {
                if (query.charAt(i) != pattern.charAt(j)) {
                    if (j > 0) j = next[j - 1];
                    else i++;
                } else {
                    j++;
                    i++;
                }
            }
            if (j == pattern.length()) return i - j;
            return -1;
        }

        int[] findNext(String str) {
            char[] arr = str.toCharArray();
            int[] next = new int[arr.length];
            int j = 0;

            for (int i = 1; i < arr.length; i++) {
                while (j != 0 && arr[j] != arr[i]) {
                    j = next[j - 1];
                }
                if (arr[i] == arr[j]) {
                    next[i] = ++j;
                }
            }

            return next;
        }
    }

    // 优化方法
    // "abcabcabc" 's next array is
    // [0, 0, 0, 1, 2, 3, 4, 5, 6]
    class Solution2 {
        public boolean repeatedSubstringPattern(String s) {
            return findNext(s);
        }

        // 优化的KMP
        boolean findNext(String str) {
            char[] arr = str.toCharArray();
            int[] next = new int[arr.length];
            int j = 0;

            for (int i = 1; i < arr.length; i++) {
                while (j != 0 && arr[j] != arr[i]) {
                    j = next[j - 1];
                }
                if (arr[i] == arr[j]) {
                    next[i] = ++j;
                }
            }

            int n = str.length();
            return next[n - 1] != 0 && n % (n - next[n - 1]) == 0;
        }
    }
}

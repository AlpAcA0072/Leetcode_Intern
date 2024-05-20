package suixianglu;

import stdLib.KMP;

public class l0028 {
    public static void main(String[] args) {
        l0028 l0028 = new l0028();
        Solution s = l0028.new Solution();
        int re = s.strStr("leetcode", "leeto");
        System.out.println(re);
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            KMP kmp = new KMP();
            int[] next = kmp.findNext(needle);
//            int[] next = findNext(needle);
            int j = 0, i = 0;
            while (i < haystack.length() && j < needle.length()) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    if (j > 0) j = next[j - 1];
                    else i++;
                } else {
                    j++;
                    i++;
                }
            }
            if (j == needle.length()) return i - j;

            return -1;
        }

    }
}

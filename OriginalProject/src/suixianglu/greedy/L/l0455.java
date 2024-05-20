package suixianglu.greedy.L;

import java.util.Arrays;

public class l0455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0;
            while (j < s.length) {
                if (i == g.length) break;
                if (g[i] <= s[j]) {
                    i++;
                }
                j++;
            }
            return i;
        }
    }
}

package suixianglu.greedy.S;

import java.util.Arrays;

public class s0455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int m = g.length, n = s.length;
            int count = 0;
            for (int i = 0, j = 0; i < m && j < n; i++, j++) {
                while (j < n && g[i] > s[j]) {
                    j++;
                }
                if (j < n) {
                    count++;
                }
            }
            return count;
        }
    }
}

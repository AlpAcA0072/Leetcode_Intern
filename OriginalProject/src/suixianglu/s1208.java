package suixianglu;

public class s1208 {
    public static void main(String[] args) {
        s1208 s1208 = new s1208();
        Solution s = s1208.new Solution();
        s.equalSubstring("ac", "ab", 0);
    }

    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int currCost = 0;
            int l = 0;
            int r = 0;
            int maxLen = 0;
            // [l, r]
            while (r < s.length()) {
                currCost += Math.abs(s.charAt(r) - t.charAt(r));
                while (currCost > maxCost) {
                    currCost -= Math.abs(s.charAt(l) - t.charAt(l));
                    l++;
                }
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
            return maxLen;
        }
    }

    // charAt()很消耗时间
    class Solution2 {
        public int equalSubstring(String s, String t, int maxCost) {
            int currCost = 0;
            int l = 0;
            int r = 0;
            int maxLen = 0;
            // [l, r]
            int[] diff = new int[s.length()];
            for (int i = 0; i < diff.length; i++) {
                diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }
            while (r < s.length()) {
                currCost += diff[r];
                while (currCost > maxCost) {
                    currCost -= diff[l];
                    l++;
                }
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
            return maxLen;
        }
    }
}

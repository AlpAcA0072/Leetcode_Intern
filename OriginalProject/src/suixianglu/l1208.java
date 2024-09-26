package suixianglu;

public class l1208 {
    public static void main(String[] args) {
        l1208 l1208 = new l1208();
        Solution s = l1208.new Solution();
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
                while (l < r && currCost > maxCost) {
                    currCost -= Math.abs(s.charAt(l) - t.charAt(l));
                    l++;
                }
                if (currCost <= maxCost) {
                    maxLen = Math.max(maxLen, r - l + 1);
                }
                r++;
            }
            return maxLen;
        }
    }
}

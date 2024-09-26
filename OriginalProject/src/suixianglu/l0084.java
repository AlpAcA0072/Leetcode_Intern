package suixianglu;

import java.util.Stack;

public class l0084 {
    public static void main(String[] args) {
        l0084 l0084 = new l0084();
        Solution s = l0084.new Solution();
        s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> s = new Stack<>();
            int[] ls = new int[heights.length];
            int[] rs = new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                    rs[s.pop()] = i;
                }
                if (s.isEmpty()) {
                    ls[i] = -1;
                } else ls[i] = s.peek();

                s.push(i);
            }
            while (!s.isEmpty()) {
                rs[s.pop()] = heights.length;
            }

            int result = 0;
            for (int i = 0; i < heights.length; i++) {
                result = Math.max(result, (rs[i] - ls[i] - 1) * heights[i]);
            }
            return result;
        }
    }
}

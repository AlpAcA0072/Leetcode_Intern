import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l0039 {
    public static void main(String[] args) {
        l0039 outer = new l0039();
        Solution sol = outer.new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        sol.combinationSum(candidates, target);
    }

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
//            for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> arr = new ArrayList<>();
            combinations(new ArrayList<>(), arr, target, candidates, 0);
//            }
            return arr;
        }

        public void combinations(List<Integer> arr, List<List<Integer>> results, int target, int[] candidates, int index) {
            if (index == candidates.length) {
                return;
            }

            if (target == 0) {
                results.add(new ArrayList<>(arr));
                // 这样是错的，因为这样只会将动态数组加入results，随着递归的外部方法修改arr，results内部的arr也会随之变动。
                // 所以需要用new ArrayList<>(arr)深拷贝一份arr，这样就不会因为arr的改变而改变results内部的数据。
//                results.add(arr);
                return;
            }

            // skip this number
            combinations(arr, results, target, candidates, index + 1);

            // use this number
            int curr = candidates[index];
            if (curr <= target) {
                arr.add(curr);
                combinations(arr, results, target - curr, candidates, index);
                arr.remove(arr.size() - 1);
            }
        }
    }
}

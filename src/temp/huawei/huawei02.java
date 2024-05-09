package temp.huawei;

import java.util.*;

public class huawei02 {
    static class soccer {
        int index;
        int sum;
        List<Integer> loss;
        int maxLen;

        public soccer(int index, int sum, int maxLen) {
            this.index = index;
            this.sum = sum;
            this.maxLen = maxLen;
            loss = new ArrayList<>();
        }
    }
    // 10 6 111111 111111 111110 011111 001111 010111 000111 000111 100001 110000
    // 10 6 110000 100001 000111 000111 010111 001111 011111 111110 111111 111111
    // 5 5 11100 00111 10111 01111 11110

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] arr = new String[n];
        for (int j = 0; j < n; j++) {
            arr[j] = in.next();
        }
        soccer[] all = new soccer[n];
        for (int i = 0; i < n; i++) {
            all[i] = new soccer(i + 1, 0, 0);
        }

        for (int i = 0; i < n; i++) {
            int currLen = 0;
            int maxLen = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '1') {
                    all[i].sum++;
                    currLen++;
                } else {
                    maxLen = Math.max(maxLen, currLen);
                    currLen = 0;
                    all[i].loss.add(j + 1);
                }
            }
            maxLen = Math.max(currLen, maxLen);
            all[i].maxLen = maxLen;
        }
        Arrays.sort(all, new Comparator<soccer>() {
            @Override
            public int compare(soccer o1, soccer o2) {
                if (o1.sum != o2.sum) {
                    return o2.sum - o1.sum;
                } else if (o2.maxLen != o1.maxLen) {
                    return o2.maxLen - o1.maxLen;
                } else {
                    // o2 - o1
                    for (int i = 0; i < o1.loss.size(); i++) {
                        if (!Objects.equals(o1.loss.get(i), o2.loss.get(i))) {
                            return o2.loss.get(i) - o1.loss.get(i);
                        }
                    }
                    return o1.index - o2.index;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                System.out.print(all[i].index + " ");
            } else System.out.print(all[i].index);
        }
    }
}

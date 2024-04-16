package stdLib;

public class KMP {
    public int[] findNext(String s) {
        char[] arr = s.toCharArray();
        int[] next = new int[arr.length];
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && arr[i] != arr[j]) {
                j = next[j - 1];
            }

            if (arr[i] == arr[j]) {
                next[i] = ++j;
            }
        }

        return next;
    }
}

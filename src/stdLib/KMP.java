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

    public int strStr(String query, String ptr) {
        int[] next = findNext(ptr);
        int j = 0, i = 0;
        while (i < query.length() && j < ptr.length()) {
            if (query.charAt(i) != ptr.charAt(j)) {
                if (j > 0) j = next[j - 1];
                else i++;
            } else {
                j++;
                i++;
            }
        }
        if (j == ptr.length()) return i - j;

        return -1;
    }
}

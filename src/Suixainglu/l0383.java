package Suixainglu;

import java.util.HashMap;
import java.util.Map;

public class l0383 {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            char[] arr = magazine.toCharArray();
            int[] counter = new int[26];

            for (char c : arr) {
                int index = (int) c - (int) 'a';
                counter[index]++;
            }

            arr = ransomNote.toCharArray();
            for (char c : arr) {
                int index = (int) c - (int) 'a';
                if (counter[index] == 0) return false;
                else counter[index]--;
            }
            return true;
        }
    }
}

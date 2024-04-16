package leetcodeHot100;

public class l0060 {
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i]++;
                    break;
                } else {
                    digits[i] = 0;
                    if (i == 0) {
                        int[] temp = new int[digits.length + 1];
                        System.arraycopy(digits, 0, temp, 1, digits.length);
                        temp[0] = 1;
                        digits = temp;
                    }
                }
            }

            return digits;
        }
    }

    class Solution2 {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i]++;
                    for (int j = i + 1; j <= digits.length - 1; j++) {
                        digits[j] = 0;
                    }
                    return digits;
                }
            }

            int[] allNine = new int[digits.length + 1];
            allNine[0] = 1;
            return allNine;
        }
    }
}

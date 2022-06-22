package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.ArrayList;
import java.util.List;

public class ReconstructOriginalDigitsFromEnglish {
    /**
     * Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending
     * order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "owoztneoer"
     * Output: "012"
     * <p>
     * Example 2:
     * <p>
     * Input: s = "fviefuro"
     * Output: "45"
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 105
     * s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
     * s is guaranteed to be valid.
     */
    public static String originalDigits(String s) {
        /*
        0, zero  z  o
        1: one      o
        2: two   w  o
        3: three    h
        4: four  u  fo
        5: five     f    i
        6: six   x  si
        7: seven    s
        8: eight g  hi
        9: nine          i
        */
        int[] intCounts = new int[10];
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            ++charCounts[c - 'a'];
        }
        char[][] filter = {
                {'z', 'o', ' '},
                {'w', 'o', ' '},
                {'u', 'f', 'o'},
                {'x', 's', 'i'},
                {'g', 'h', 'i'}
        };
        for (int i = 0; i < 5; ++i) {
            System.out.println(i + ", " + (int) (filter[i][0] - 'a') + "," + (int) (filter[i][1] - 'a') + "," + (filter[i][2] - 'a'));
            if (charCounts[filter[i][0] - 'a'] > 0) {
                intCounts[i << 1] = charCounts[filter[i][0] - 'a'];
                charCounts[filter[i][1] - 'a'] -= charCounts[filter[i][0] - 'a'];
                if (i > 1) {
                    charCounts[filter[i][2] - 'a'] -= charCounts[filter[i][0] - 'a'];
                }
                charCounts[filter[i][0] - 'a'] = 0;
            }
        }
        filter = new char[][]{
                {'o', ' '},
                {'h', ' '},
                {'f', 'i'},
                {'s', ' '},
        };
        for (int i = 0; i < 4; ++i) {
            System.out.println(i + ", " + (int) (filter[i][0] - 'a') + "," + (int) (filter[i][1] - 'a'));
            if (charCounts[filter[i][0] - 'a'] > 0) {
                intCounts[(i << 1) + 1] += charCounts[filter[i][0] - 'a'];

                if (i == 2) {
                    charCounts[filter[i][1] - 'a'] -= charCounts[filter[i][0] - 'a'];
                }
                charCounts[filter[i][0] - 'a'] = 0;
            }
        }

        intCounts[9] = charCounts['i' - 'a'];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < intCounts.length; ++i) {
            for (int j = 0; j < intCounts[i]; ++j) {
                sb.append(i);
            }
        }

        return sb.toString();
    }


    public static String originalDigits2(String s) {
        /*
        0, zero  z  o
        1: one      o
        2: two   w  o
        3: three    h
        4: four  u  fo
        5: five     f    i
        6: six   x  si
        7: seven    s
        8: eight g  hi
        9: nine          i
        */
        int[] intCounts = new int[10];
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            ++charCounts[c - 'a'];
        }
        int totalCount = 0;
        int[][] filter = {
                {25, 14, 0},
                {22, 14, 0},
                {20, 5, 14},
                {23, 18, 8},
                {6, 7, 8},
        };
        for (int i = 0; i < 5; ++i) {
            if (charCounts[filter[i][0]] > 0) {
                totalCount += charCounts[filter[i][0]];
                intCounts[i << 1] = charCounts[filter[i][0]];
                charCounts[filter[i][1]] -= charCounts[filter[i][0]];
                if (i > 1) {
                    charCounts[filter[i][2]] -= charCounts[filter[i][0]];
                }
                charCounts[filter[i][0]] = 0;
            }
        }
        filter = new int[][]{
                {14, 0},
                {7, 0},
                {5, 8},
                {18, 0},
        };
        for (int i = 0; i < 4; ++i) {
            if (charCounts[filter[i][0]] > 0) {
                totalCount += charCounts[filter[i][0]];
                intCounts[(i << 1) + 1] += charCounts[filter[i][0]];
                if (i == 2) {
                    charCounts[filter[i][1]] -= charCounts[filter[i][0]];
                }
                charCounts[filter[i][0]] = 0;
            }
        }

        intCounts[9] = charCounts[8];
        totalCount += charCounts[8];
        char[] result = new char[totalCount];
        int index = 0;
        for (int i = 0; i < intCounts.length; ++i) {
            for (int j = 0; j < intCounts[i]; ++j) {
                result[index] = (char)(i + '0');
                ++index;
            }
        }

        return new String(result);
    }
}

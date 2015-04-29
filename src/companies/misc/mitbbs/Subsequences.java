package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Sep 12, 2013 4:52:53 PM
 */
public class Subsequences {
    /*
    You're given a large string T. And a stream of smaller string S1, S2, S3 ...

    Determine whether Si is a subsequence of T.

    |T| < 10 000 000
    |Si| < 100
    alphabet is 'a' - 'z'

    T = abcdefg
    S1 = abc        yes
    S2 = ag          yes
    S3 = ga          no
    S4 = aa          no
    */

    public static boolean[] isSubsequence(String t, String... s) {
        boolean[] ret = new boolean[s.length];

        //pre-process t
        int[][] index = getIndex(t);

        //process array s
        for (int i = 0; i < s.length; i++) {
            ret[i] =  process(index, s[i]);
        }

        return ret;
    }

    private static int[][] getIndex(String t) {
        int[][] ret = new int[256][t.length()];
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < t.length(); j++) {
                ret[i][j] = -1;
            }
        }

        for (int i = 0, n = t.length(); i < n; i++) {
            char c = t.charAt(i);
            ret[c][i] = i;
            for (int j = i - 1; j >= 0 && ret[c][j] == -1; ret[c][j] = i, j--);
        }

        return ret;
    }

    private static boolean process(int[][] index, String s) {
        int currentIdx = -1;
        for (char c : s.toCharArray()) {
            if (++currentIdx >= index[0].length) {
                return false;
            }
            currentIdx = index[c][currentIdx];
            if (currentIdx == -1) {
                return false;
            }
        }

        return true;
    }

    public static void test() {
        Utils.printTestBooleanArrayln(isSubsequence("abcdefg", "abc", "ag", "ga", "aa"), new boolean[] {true, true, false, false});
    }

    public static void main(String[] args) {
        test();
    }
}

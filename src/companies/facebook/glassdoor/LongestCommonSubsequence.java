package companies.facebook.glassdoor;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 8, 2014 3:16:00 PM
 */
public class LongestCommonSubsequence {
    /*
    ongest common subsequence is the subsequence that appear in multiple sequences (usually two) simultaneously. For
    example, the longest common sequence of "13486" and "23861' is "386". The diff program is based on this algorithm.
    Besides, this algorithm is frequently used in bioinformatic research.
     */
    public static String getLCS(String s1, String s2) {
        
        return getLCS(s1, 0, s2, 0);
    }

    private static String getLCS(String s1, int i1, String s2, int i2) {
        if (i1 >= s1.length() || i2 >= s2.length()) {
            return "";
        }

        String ret, ret1;

        ret = getLCS(s1, i1 + 1, s2, i2);
        ret1 = getLCS(s1, i1, s2, i2 + 1);
        if (ret1.length() > ret.length()) {
            ret = ret1;
        }

        if (s1.charAt(i1) == s2.charAt(i2) && (ret1 = getLCS(s1, i1 + 1, s2, i2 + 1)).length() + 1 > ret.length()) {
            ret = s1.charAt(i1) + ret;
        }

        return ret;
    }

    public static String getLCSDP(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int[][] path = new int[s1.length()][s2.length()];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    dp[i][j] = dp[i + 1][j];
                    path[i][j] = 3;
                } else {
                    dp[i][j] = dp[i][j + 1];
                    path[i][j] = 1;
                }
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (dp[i][j] < dp[i + 1][j + 1] + 1) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                        path[i][j] = 2;
                    }
                }
            }
        }

        StringBuffer ret = new StringBuffer();
        for (int i = 0, j = 0; i < s1.length() && j < s2.length();) {
            switch(path[i][j]) {
                case 1: j++; break;
                case 2: ret.append(s1.charAt(i)); i++; j++; break;
                case 3: i++; break;
            }
        }

        return ret.toString();
    }

    private static void test() {
        Utils.printTestln(getLCS("13486", "23861"), "386");
        Utils.printTestln(getLCS("1234", "1224533324"), "1234");

        Utils.printTestln(getLCSDP("13486", "23861"), "386");
        Utils.printTestln(getLCSDP("1234", "1224533324"), "1234");
    }

    public static void main(String[] args) {
        test();
    }
    
}

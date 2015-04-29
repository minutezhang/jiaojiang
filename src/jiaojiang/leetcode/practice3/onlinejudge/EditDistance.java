package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/10/15 6:09 PM
 */
public class EditDistance {
    /*
    Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
    (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    a) Insert a character
    b) Delete a character
    c) Replace a character
     */
    public static int minDistance(String word1, String word2) {
        return minDistance(word1, 0, word2, 0);
    }

    private static int minDistance(String word1, int s1, String word2, int s2) {
        if (s1 == word1.length()) {
            return word2.length() - s2;
        }

        if (s2 == word2.length()) {
            return word1.length() - s1;
        }

//        int distance = 1 + Math.min(minDistance(word1, s1, word2, s2 + 1), minDistance(word1, s1 + 1, word2, s2));

        if (word1.charAt(s1) != word2.charAt(s2)) {
//            return Math.min(1 + minDistance(word1, s1 + 1, word2, s2 + 1), distance);
            return 1 + Math.min(minDistance(word1, s1 + 1, word2, s2 + 1), Math.min(minDistance(word1, s1 + 1, word2, s2), minDistance(word1, s1, word2, s2 + 1)));
        }

//        return Math.min(minDistance(word1, s1 + 1, word2, s2 + 1), distance);
        return minDistance(word1, s1 + 1, word2, s2 + 1);
    }

    public static int minDistanceDP(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp  = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l2 + 1; i++) {
            dp[l1][i] = l2 - i;
        }

        for (int i = 0; i < l1 + 1; i++) {
            dp[i][l2] = l1 - i;
        }

        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                dp[i][j] = word1.charAt(i) == word2.charAt(j) ? dp[i + 1][j + 1] : 1 + Math.min(Math.min(dp[i + 1][j + 1], dp[i + 1][j]), dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }

    public static int minDistance2DP(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp  = new int[2][l2 + 1];

        for (int i = 0; i < l2 + 1; i++) {
            dp[l1 & 1][i] = l2 - i;
        }

        for (int i = l1 - 1; i >= 0; i--) {
            dp[i & 1][l2] = l1 - i;
            for (int j = l2 - 1; j >= 0; j--) {
                dp[i & 1][j] = word1.charAt(i) == word2.charAt(j) ? dp[(i + 1) & 1][j + 1] : 1 + Math.min(Math.min(dp[(i + 1) & 1][j + 1], dp[(i + 1) & 1][j]), dp[i & 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}

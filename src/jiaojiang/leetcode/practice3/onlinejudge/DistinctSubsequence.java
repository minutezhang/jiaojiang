package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 20, 2015 12:00:15 AM
 */
public class DistinctSubsequence {
    /*
     Given a string S and a string T, count the number of distinct subsequences of T in S.

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
    of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence
    of "ABCDE" while "AEC" is not).

    Here is an example:
    S = "rabbbit", T = "rabbit"

    Return 3.
     */
    public static int numDistinct(String S, String T) {
        return numDistinct(S, 0, T, 0);
    }

    private static int numDistinct(String S, int s1, String T, int s2) {
        if (s2 == T.length()) {
            return 1;
        }

        if (s1 == S.length()) {
            return 0;
        }


        if (S.charAt(s1) == T.charAt(s2)) {
            return numDistinct(S, s1 + 1, T, s2 + 1) + numDistinct(S, s1 + 1, T, s2);
        }

        return numDistinct(S, s1 + 1, T, s2);
    }

    public static int numDistinctDP(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length() + 1; i++) {
            dp[i][T.length()] = 1;
        }

        for (int i = 0; i < T.length(); i++) {
            dp[S.length()][i] = 0;
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = T.length() - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + (S.charAt(i) == T.charAt(j) ? dp[i + 1][j + 1] : 0);
            }
        }

        return dp[0][0];
    }

    public static int numDistinct2DP(String S, String T) {
        int[] dp = new int[T.length() + 1];
        dp[T.length()] = 1;

        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = 0; j < T.length(); j++) {
                dp[j] = dp[j] + (S.charAt(i) == T.charAt(j) ? dp[j + 1] : 0);
            }
        }

        return dp[0];
    }
}
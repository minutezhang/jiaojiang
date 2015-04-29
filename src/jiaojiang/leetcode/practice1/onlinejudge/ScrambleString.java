package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 2:26:13 PM
 */
public class ScrambleString {
    /*
     Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

    Below is one possible representation of s1 = "great":

        great
       /    \
      gr    eat
     / \    /  \
    g   r  e   at
               / \
              a   t

    To scramble the string, we may choose any non-leaf node and swap its two children.

    For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

        rgeat
       /    \
      rg    eat
     / \    /  \
    r   g  e   at
               / \
              a   t

    We say that "rgeat" is a scrambled string of "great".

    Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

        rgtae
       /    \
      rg    tae
     / \    /  \
    r   g  ta  e
           / \
          t   a

    We say that "rgtae" is a scrambled string of "great".

    Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
    */
    public static boolean isScramble(String s1, String s2) {
        int l = s1.length();
        if (l != s2.length()) {
            return false;
        }

        if (l == 1) {
            return s1.equals(s2);
        }

        for (int i = 1; i < l; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, l), s2.substring(i, l)) ||
                    isScramble(s1.substring(0, i), s2.substring(l - i, l)) && isScramble(s1.substring(i, l), s2.substring(0, l - i))
            ) {
                return true;
            }
        }
        return false;
    }

    /*
    dp[i][j][k] represent the string s1 start from i, string s2 starting from j, both with length k + 1 is Scramble.

    dp[i][j][k] = OR (m = 0, 1, ..., k - 1)
                  dp[i][j][m] && dp[i + m + 1][j + m + 1][k - m - 1] || dp[i][j + k - m][m] && dp[i + m + 1][j][k - m -1]
     */
    public static boolean isScrambleDP(String s1, String s2) {
        int l = s1.length();
        if (l != s2.length()) {
            return false;
        }

        boolean[][][] dp = new boolean[l][l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 1; k < l; k++) {
            for (int i = 0; i < l - k; i++) {
                for (int j = 0; j < l - k; j++) {
                    for (int m = 0; m < k; m++) {
                        dp[i][j][k] = dp[i][j][k] || dp[i][j][m] && dp[i + m + 1][j + m + 1][k - m - 1] || dp[i][j + k - m][m] && dp[i + m + 1][j][k - m -1];
                    }
                }
            }
        }
        return dp[0][0][l - 1];
    }

    public static void test() {
        Utils.printTestln(isScramble("great", "rgeat"), true);
        Utils.printTestln(isScramble("abcd", "bdac"), false);

        Utils.printTestln(isScrambleDP("great", "rgeat"), true);
        Utils.printTestln(isScrambleDP("abcd", "bdac"), false);
    }

    public static void main(String[] args) {
        test();
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/4/15 7:04 PM
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
        return isScramble(s1, 0, s2, 0, s1.length());
    }

    private static boolean isScramble(String s1, int start, String s2, int start2, int length) {
        if (length == 0) {
            return true;
        }

        if (length == 1) {
            return s1.charAt(start) == s2.charAt(start2);
        }

        for (int i = 1; i < length; i++) {
            if (isScramble(s1, start, s2, start2, i) && isScramble(s1, start + i, s2, start2 + i, length - i) ||
                    isScramble(s1, start, s2, start2 + length - i, i) && isScramble(s1, start + i, s2, start2, length - i)) {
                return true;
            }
        }

        return false;
    }


    // dp(i, j, k) = dp(i, j , ii) && dp(i + ii, j + ii, k - ii) || dp(i, j + k - ii, ii) && dp(i + ii, j, k - ii) for ii = 1, ..., k
    public static boolean isScrambleDP(String s1, String s2) {
        int length = s1.length();
        boolean[][][] dp  = new boolean[length][length][length + 1];


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j][0] = true;
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 2; k < length + 1; k++) {
            for (int i = 0; i < length - k + 1; i++) {
                for (int j = 0; j < length - k + 1; j++) {
                    for (int l = 1; l < k && !dp[i][j][k]; l++) {
                        dp[i][j][k] = dp[i][j][l] && dp[i + l][j + l][k - l] || dp[i][j + k - l][l] && dp[i + l][j][k - l];
                    }
                }
            }
        }

        return dp[0][0][length];
    }
}

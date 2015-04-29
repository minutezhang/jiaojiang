package jiaojiang.leetcode.practice3.onlinejudge;

import sun.misc.MessageUtils;

/**
 * @author: mizhang
 * @time: 2/24/15 11:24 PM
 */
public class LongestPalindromicSubstring {
    /*
    Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
    and there exists one unique longest palindromic substring.
     */

    // DP[i][j] = DP[i + 1][j - 1] && s[i] == s[j];
    // belos dp array means isNotPalindrome to save the initialization(default value is false)
    public static String longestPalindrome(String s) {
        int start = 0, end = 0, l = s.length();
        boolean[][] dp = new boolean[l][2];

        for (int i = 1; i < l; i++) {
            for (int j = 0; j < l - i; j++) {
                if(!(dp[j][i & 1] = dp[j + 1][i & 1] || s.charAt(i + j) != s.charAt(j))) {
                    start = j;
                    end = i + j;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}

package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang@akamai.com
 */
public class LongestPalindromicSubstring {
    /*
    Given a string S, find the longest palindromic substring in S. You may assume
    that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
     */

    public static String longestPalindrome(String s) {
        int l = s.length(), longest = 1, start = 0, end = 0;
        boolean[][] dp = new boolean[l][l];

        for (int i = 0; i < l - 1; i++) {
            dp[i][i] = true;
            if(s.charAt(i) == s.charAt(i + 1)) {
                longest = 2;
                start = i;
                end = i + 1;
                dp[i][i + 1] = true;
            }
        }
        dp[l - 1][l - 1] = true;

        for (int i = l - 3; i >= 0; i--) {
            for (int j = i + 2; j < l; j++) {
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (longest < j - i + 1) {
                        start = i;
                        end = j;
                        longest = j - i + 1;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void test() {
        Utils.printTestln(longestPalindrome("abb"), "bb");
        Utils.printTestln(longestPalindrome("aaaabaaa"), "aaabaaa");
    }

    public static void main(String[] args) {
        test();
    }
}

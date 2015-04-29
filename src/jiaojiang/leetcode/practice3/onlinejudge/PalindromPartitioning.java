package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/27/15 11:14 AM
 */
public class PalindromPartitioning {
    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]
     */
    public static List<List<String>> partition(String s) {
        return partition(s, 0);
    }

    private static List<List<String>> partition(String s, int start) {
        List<List<String>> ret = new ArrayList<List<String>>();

        if (start == s.length()) {
            ret.add(new ArrayList<String>());
            return ret;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                for (List<String> l: partition(s, i + 1)) {
                    l.add(0, s.substring(start, i + 1));
                    ret.add(l);
                }
            }
        }

        return ret;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }

    public static List<List<String>> partitionDP(String s) {
        return partitionDP(s, 0, constructMatrix(s));
    }

    private static boolean[][] constructMatrix(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];

        for (int i = 1; i < l; i++) {
            for (int j = 0; j < l - i; j++) {
                dp[j][j + i] = dp[j + 1][j + i - 1] || s.charAt(j) != s.charAt(j + i);
            }
        }

        return dp;
    }

    private static List<List<String>> partitionDP(String s, int start, boolean[][] dp) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (start == s.length()) {
            ret.add(new ArrayList<String>());
            return ret;
        }

        for (int i = start; i < s.length(); i++) {
            if (!dp[start][i]) {
                for (List<String> l: partitionDP(s, i + 1, dp)) {
                    l.add(0, s.substring(start, i + 1));
                    ret.add(l);
                }
            }
        }

        return ret;
    }
}
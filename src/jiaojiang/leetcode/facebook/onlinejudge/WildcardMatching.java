package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 7, 2016
 */
public class WildcardMatching {
    /*
    Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") ? false
    isMatch("aa","aa") ? true
    isMatch("aaa","aa") ? false
    isMatch("aa", "*") ? true
    isMatch("aa", "a*") ? true
    isMatch("ab", "?*") ? true
    isMatch("aab", "c*a*b") ? false
     */
//    public static boolean isMatch(String s, String p) {
//        int m = s.length(), n = p.length();
//        boolean[][] dp = new boolean[m][n];
//
//
//
//    }

    public static boolean isMatchMem(String s, String p) {
        return isMatchMem(s, 0, p, 0, new Boolean[s.length()][p.length()]);
    }

    private static boolean isMatchMem(String s, int i, String p, int j, Boolean[][] isMatch) {
        if (i == s.length()) {
            for (; j < p.length() && p.charAt(j) == '*'; j++) ;
            return j == p.length();
        }

        if (j == p.length()) {
            return i == s.length();
        }

        if (isMatch[i][j] != null) {
            return isMatch[i][j];
        }

        if (p.charAt(j) == '*') {
            return isMatch[i][j] = (isMatchMem(s, i, p, j + 1, isMatch) || isMatchMem(s, i + 1, p, j, isMatch));
        }

        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            return isMatch[i][j] = (isMatchMem(s, i + 1, p, j + 1, isMatch));
        }

        return isMatch[i][j] = false;
    }


    public static boolean isMatchRecursion(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private static boolean isMatch(String s, int i, String p, int j) {
        if (i == s.length()) {
            for (; j < p.length() && p.charAt(j) == '*'; j++) ;
            return j == p.length();
        }

        if (j == p.length()) {
            return i == s.length();
        }

        if (p.charAt(j) == '*') {
            return isMatch(s, i, p, j + 1) || isMatch(s, i + 1, p, j);
        }

        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            return isMatch(s, i + 1, p, j + 1);
        }

        return false;
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Mar 22, 2015 10:28:37 PM
 */
public class RegularExpressionMatching {
    /*
    Implement regular expression matching with support for '.' and '*'.

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") ? false
    isMatch("aa","aa") ? true
    isMatch("aaa","aa") ? false
    isMatch("aa", "a*") ? true
    isMatch("aa", ".*") ? true
    isMatch("ab", ".*") ? true
    isMatch("aab", "c*a*b") ? true
     */
    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private static boolean isMatch(String s, int sStart, String p, int pStart) {
        if (pStart == p.length()) {
            return sStart >= s.length();
        }

        if (pStart < p.length() - 1 && p.charAt(pStart + 1) == '*') {
            if (p.charAt(pStart) == '.' || p.charAt(pStart) == s.charAt(sStart)) {
                return isMatch(s, sStart + 1, p, pStart) || isMatch(s, sStart, p, pStart + 2);
            }
            return isMatch(s, sStart, p, pStart + 1);
        }

        if (p.charAt(pStart) == '.' || p.charAt(pStart) == s.charAt(sStart)) {
            return isMatch(s, sStart + 1, p, pStart + 1);
        }

        return false;
    }
}

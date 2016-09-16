package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 7, 2016
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

    private static boolean isMatch(String s, int startS, String p, int startP) {
        if (startS == s.length()) {
            for (; startP + 1 < p.length() && p.charAt(startP + 1) == '*'; startP += 2);
            return startP == p.length();
        }

        if (startP == p.length()) {
            return startS == s.length();
        }

        if (startP + 1 < p.length() && p.charAt(startP + 1) == '*') {
            if (p.charAt(startP) == '.' || p.charAt(startP) == s.charAt(startS)) {
                return isMatch(s, startS + 1, p, startP + 2) || isMatch(s, startS, p, startP + 2) || isMatch(s, startS + 1, p, startP);
            }
            return isMatch(s, startS, p, startP + 2); 
        } else {
            if (p.charAt(startP) == '.' || p.charAt(startP) == s.charAt(startS)) {
                return isMatch(s, startS + 1, p, startP + 1);
            }
        }

        return false;
    }
}

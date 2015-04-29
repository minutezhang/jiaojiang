package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

/**
 * @author: mizhang
 * @since: Dec 2, 2014 5:14:41 PM
 */
public class InterleavingString {
    /*
    Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

    For example,
    Given:
    s1 = "aabcc",
    s2 = "dbbca",

    When s3 = "aadbbcbcac", return true.
    When s3 = "aadbbbaccc", return false.
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3);
    }

    public static boolean isInterleave(String s1, int start1, String s2, int start2, String s3) {
        if (start1 == s1.length()) {
            return s2.substring(start2).equals(s3.substring(start1 + start2));
        }

        if (start2 == s2.length()) {
            return s1.substring(start1).equals(s3.substring(start1 + start2));
        }

        if (s1.charAt(start1) != s3.charAt(start1 + start2) && s2.charAt(start2) != s3.charAt(start1 + start2)) {
            return false;
        }

        if (s1.charAt(start1) == s3.charAt(start1 + start2) && s2.charAt(start2) != s3.charAt(start1 + start2)) {
            return isInterleave(s1, start1 + 1, s2, start2, s3);
        }

        if (s1.charAt(start1) != s3.charAt(start1 + start2) && s2.charAt(start2) == s3.charAt(start1 + start2)) {
            return isInterleave(s1, start1, s2, start2 + 1, s3);
        }

        return isInterleave(s1, start1 + 1, s2, start2, s3) || isInterleave(s1, start1, s2, start2 + 1, s3);
    }

    public static boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i + 1][s2.length()] && s1.charAt(i) == s3.charAt(i + s2.length());
        }

        for (int i = s2.length() - 1; i >= 0; i--) {
            dp[s1.length()][i] = dp[s1.length()][i + 1] && s2.charAt(i) == s3.charAt(i + s1.length());
        }

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) != s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i + j)) {
                    dp[i][j] = false;
                }
                if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i + j)) {
                    dp[i][j] = dp[i + 1][j];
                }
                if (s1.charAt(i) != s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j + 1];
                }
                if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }

    public static boolean isInterleave3(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[s2.length() + 1];
        dp[s2.length()] = true;

        for (int i = s2.length() - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] && s2.charAt(i) == s3.charAt(i + s1.length());
        }

        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[s2.length()] = dp[s2.length()] && s1.charAt(i) == s3.charAt(i + s2.length());
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) != s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i + j)) {
                    dp[j] = false;
                }
                if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i + j)) {
                    dp[j] = dp[j];
                }
                if (s1.charAt(i) != s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[j] = dp[j + 1];
                }
                if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[j] = dp[j + 1] || dp[j];
                }
            }
        }

        return dp[0];
    }

    public static void test() {
        Test.assertTrue(!isInterleave("", "", "a"));
        Test.assertTrue(isInterleave("", "a", "a"));
        Test.assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Test.assertTrue(!isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        Test.assertTrue(!isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
        
        System.out.println();

        Test.assertTrue(!isInterleave2("", "", "a"));
        Test.assertTrue(isInterleave2("", "a", "a"));
        Test.assertTrue(!isInterleave2("", "b", "a"));
        Test.assertTrue(isInterleave2("aabcc", "dbbca", "aadbbcbcac"));
        Test.assertTrue(!isInterleave2("aabcc", "dbbca", "aadbbbaccc"));
        Test.assertTrue(!isInterleave2("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));

        System.out.println();

        Test.assertTrue(!isInterleave3("", "", "a"));
        Test.assertTrue(isInterleave3("", "a", "a"));
        Test.assertTrue(isInterleave3("aabcc", "dbbca", "aadbbcbcac"));
        Test.assertTrue(!isInterleave3("aabcc", "dbbca", "aadbbbaccc"));
        Test.assertTrue(!isInterleave3("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }

    public static void main(String[] args) {
        test();
    }
}

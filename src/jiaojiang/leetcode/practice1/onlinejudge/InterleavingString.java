package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 29, 2013 12:08:12 AM
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
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    public static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i1 == s1.length()) {
            return s2.substring(i2).equals(s3.substring(i3));
        }

        if (i2 == s2.length()) {
            return s1.substring(i1).equals(s3.substring(i3));
        }

//        if (s1.charAt(i1) != s3.charAt(i3) && s2.charAt(i2) != s3.charAt(i3)) {
//            return false;
//        }
//
//        if (s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3)) {
//            return isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1) || isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
//        }
//
//        if (s1.charAt(i1) == s3.charAt(i3)) {
//            return isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
//        }
//
//        return isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
        return s1.charAt(i1) == s3.charAt(i3) && isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1) || s2.charAt(i2) == s3.charAt(i3) && isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
    }

    public static boolean isInterleaveDP(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] flags = new boolean[s1.length() + 1][s2.length() + 1];
        flags[s1.length()][s2.length()] = true;

        for (int i = s1.length() - 1; i >= 0; i--) {
            flags[i][s2.length()] = flags[i + 1][s2.length()] && s1.charAt(i) == s3.charAt(s2.length() + i);
        }

        for (int i = s2.length() - 1; i >= 0; i--) {
            flags[s1.length()][i] = flags[s1.length()][i + 1] && s2.charAt(i) == s3.charAt(s1.length() + i);
        }

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                flags[i][j] = s1.charAt(i) == s3.charAt(i + j) && flags[i + 1][j] || s2.charAt(j) == s3.charAt(i + j) && flags[i][j + 1];
            }
        }
        return flags[0][0];
    }

    public static void test() {
        System.out.println(isInterleave("ab", "cd", "abcd"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));

        System.out.println(isInterleaveDP("ab", "cd", "abcd"));
        System.out.println(isInterleaveDP("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleaveDP("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static void main(String[] args) {
        test();
    }
}

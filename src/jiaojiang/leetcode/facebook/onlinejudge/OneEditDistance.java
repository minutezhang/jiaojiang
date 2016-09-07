package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
 */
public class OneEditDistance {
    /*
    Given two strings S and T, determine if they are both one edit distance apart.
    hints:
    There are three 1-edit distance operations shown as below:
    1. Modify (shift = 0):
    abcde
    abXde
    2. Append (shift = 1):
    abcde
    abcdeX
    3. Insert (shift = 1):
    abcde
    abcdeX
    We use shift to show the difference of the length of two strings.
     */
    public static boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            return isOneEditDistance(t, s);
        }

        if (s.length() - t.length() > 1) {
            return false;
        }

        int diffCount = 0, i, j ;
        for (i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                if (s.length() > t.length()) {
                    j--;
                }
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }

        return diffCount + s.length() - i <= 1;
    }
}

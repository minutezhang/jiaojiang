package jiaojiang.leetcode.practice5.onlinejudge;

import utils.Utils;

public class RepeatedSubstringPattern {
    /**
     * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of
     * the substring together.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abab"
     * Output: true
     * Explanation: It is the substring "ab" twice.
     * <p>
     * Example 2:
     * <p>
     * Input: s = "aba"
     * Output: false
     * <p>
     * Example 3:
     * <p>
     * Input: s = "abcabcabcabc"
     * Output: true
     * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 10^4
     * s consists of lowercase English letters.
     */
    public static boolean repeatedSubstringPattern(String s) {
        int[] lps = new int[s.length()];
        lps[0] = 0;
        for (int i = 1; i < s.length(); ++i) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            lps[i] = s.charAt(i) == s.charAt(j) ? j + 1 : 0;
        }

        return lps[s.length() - 1] != 0 && s.length() % (s.length() - lps[s.length() - 1]) == 0;
    }
}

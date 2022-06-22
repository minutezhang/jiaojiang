package jiaojiang.leetcode.practice5.onlinejudge;

public class RepeatedStringMatch {
    /**
     * Given two strings a and b, return the minimum number of times you should repeat string a so that string b
     * is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
     *
     * Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
     *
     * Example 1:
     *
     * Input: a = "abcd", b = "cdabcdab"
     * Output: 3
     * Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
     *
     * Example 2:
     *
     * Input: a = "a", b = "aa"
     * Output: 2
     *
     *
     *
     * Constraints:
     *
     *     1 <= a.length, b.length <= 104
     *     a and b consist of lowercase English letters.
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

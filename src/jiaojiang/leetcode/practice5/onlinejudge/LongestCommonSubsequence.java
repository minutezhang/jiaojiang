package jiaojiang.leetcode.practice5.onlinejudge;

public class LongestCommonSubsequence {
    /**
     * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
     * <p>
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     * <p>
     * For example, "ace" is a subsequence of "abcde".
     * <p>
     * A common subsequence of two strings is a subsequence that is common to both strings.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: text1 = "abcde", text2 = "ace"
     * Output: 3
     * Explanation: The longest common subsequence is "ace" and its length is 3.
     * <p>
     * Example 2:
     * <p>
     * Input: text1 = "abc", text2 = "abc"
     * Output: 3
     * Explanation: The longest common subsequence is "abc" and its length is 3.
     * <p>
     * Example 3:
     * <p>
     * Input: text1 = "abc", text2 = "def"
     * Output: 0
     * Explanation: There is no such common subsequence, so the result is 0.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= text1.length, text2.length <= 1000
     * text1 and text2 consist of only lowercase English characters.
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); ++i) {
            for (int j = 0; j < text2.length(); ++j) {
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence2(text2, text1);
        }
        int[] dp = new int[text2.length() + 1];
        for (int i = 0; i < text1.length(); ++i) {
            int diagonal = 0;
            for (int j = 0; j < text2.length(); ++j) {
                int newDiagonal = dp[j + 1];
                dp[j + 1] = text1.charAt(i) == text2.charAt(j) ? diagonal + 1 : Math.max(dp[j + 1], dp[j]);
                diagonal = newDiagonal;
            }
        }
        return dp[text2.length()];
    }
}

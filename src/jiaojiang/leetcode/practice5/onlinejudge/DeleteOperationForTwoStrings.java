package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteOperationForTwoStrings {
    /**
     * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
     * <p>
     * In one step, you can delete exactly one character in either string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: word1 = "sea", word2 = "eat"
     * Output: 2
     * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
     * <p>
     * Example 2:
     * <p>
     * Input: word1 = "leetcode", word2 = "etco"
     * Output: 4
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= word1.length, word2.length <= 500
     * word1 and word2 consist of only lowercase English letters.
     */
    public static int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i < word1.length(); ++i) {
            int diagonal = 0;
            for (int j = 0; j < word2.length(); ++j) {
                int newDiagonal = dp[j + 1];
                dp[j + 1] = word1.charAt(i) == word2.charAt(j) ? diagonal + 1 : Math.max(dp[j + 1], dp[j]);
                diagonal = newDiagonal;
            }
        }
        return word1.length() + word2.length() - 2 * dp[word2.length()];
    }
}

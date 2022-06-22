package jiaojiang.leetcode.practice5.onlinejudge;

public class LongestRepeatingCharacterReplacement {
    /**
     * You are given a string s and an integer k. You can choose any character of the string and change it to any other
     * uppercase English character. You can perform this operation at most k times.
     * <p>
     * Return the length of the longest substring containing the same letter you can get after performing the above
     * operations.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     * <p>
     * Example 2:
     * <p>
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 105
     * s consists of only uppercase English letters.
     * 0 <= k <= s.length
     */
    public static int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int start = 0, end = 0, maxTotal = 0;
        s = s.toLowerCase();
        while (end < s.length()) {
            ++counts[s.charAt(end) - 'a'];
            ++end;
            while (end - start > k && diffCount(counts) > k) {
                --counts[s.charAt(start) - 'a'];
                ++start;
            }
            maxTotal = Math.max(maxTotal, end - start);
        }
        return maxTotal;
    }

    private static int diffCount(int[] counts) {
        int majorityCount = 0, totalCount = 0;
        for (int count : counts) {
            if (count > majorityCount) {
                majorityCount = count;
            }
            totalCount += count;
        }
        return totalCount - majorityCount;
    }
}

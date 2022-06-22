package jiaojiang.leetcode.practice5.onlinejudge;

public class UniqueSubstringsInWraparoundString {
    /**
     * We define the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look
     * like this:
     * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
     * Given a string p, return the number of unique non-empty substrings of p are present in s.
     * <p>
     * Example 1:
     * <p>
     * Input: p = "a"
     * Output: 1
     * Explanation: Only the substring "a" of p is in s.
     * <p>
     * Example 2:
     * <p>
     * Input: p = "cac"
     * Output: 2
     * Explanation: There are two substrings ("a", "c") of p in s.
     * <p>
     * Example 3:
     * <p>
     * Input: p = "zab"
     * Output: 6
     * Explanation: There are six substrings ("z", "a", "b", "za", "ab", and "zab") of p in s.
     * <p>
     * Constraints:
     * <p>
     * 1 <= p.length <= 105
     * p consists of lowercase English letters.
     */
    public static int findSubstringInWraproundString(String p) {
        char[] charArray = p.toCharArray();
        int[] maxLength = new int[26];
        int count = 0;
        for (int i = 0; i < charArray.length;) {
            int index;
            for (index = i + 1; index < charArray.length && (charArray[index] - charArray[index - 1] == 1 || charArray[index] - charArray[index - 1] == -25); ++index);
            for (int j = i; j < index; ++j) {
                if (index - j > maxLength[charArray[j] - 'a']) {
                    count += index - j - maxLength[charArray[j] - 'a'];
                    maxLength[charArray[j] - 'a'] = index - j;
                }
            }
            i = index;
        }
        return count;
    }

    public static int findSubstringInWraproundString2(String p) {
        char[] charArray = p.toCharArray();
        int[] maxLength = new int[26];
        int count = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (maxLength[charArray[i] - 'a'] == 0) {
                maxLength[charArray[i] - 'a'] = 1;
                ++count;
            }
            for (int j = i + 1; j < charArray.length && (charArray[j] - charArray[j - 1] == 1 || charArray[j] - charArray[j - 1] == -25); ++j) {
                if (maxLength[charArray[i] - 'a'] < j - i + 1) {
                    ++count;
                    maxLength[charArray[i] - 'a'] = j - i + 1;
                }
            }
        }
        return count;
    }
}

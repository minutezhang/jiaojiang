package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/3/15 10:02 AM
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    Given a string, find the length of the longest substring without repeating characters. For example, the longest
    substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest
    substring is "b", with the length of 1.
     */
    public static int lengthOfLongestSubstring(String s) {
        boolean[] hasChar = new boolean[256];
        int maxLength, start, end;
        for(maxLength = start = end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (!hasChar[c]){
                hasChar[c] = true;
            } else {
                maxLength = Math.max(maxLength, end - start);
                for(char c2 ;start < end && (c2 = s.charAt(start)) != c; hasChar[c2] = false, start++);
                start++;
            }
        }

        return Math.max(maxLength, end - start);
    }
}

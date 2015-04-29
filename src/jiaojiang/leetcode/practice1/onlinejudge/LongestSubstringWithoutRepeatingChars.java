package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Map;
import java.util.HashMap;

/**
 * @author: zhang
 * @since: May 12, 2013 9:30:02 PM
 */
public class LongestSubstringWithoutRepeatingChars {
    /*
    Given a string, find the length of the longest substring without repeating characters. For example,
    the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
    For "bbbbb" the longest substring is "b", with the length of 1.
    */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indices = new HashMap<Character, Integer>();
        int start = 0,maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!indices.containsKey(c)) {
                indices.put(c, i);
            } else {
                maxLength = Math.max(maxLength, i - start);
                for (int j = start; j < indices.get(c); j++) {
                    indices.remove(s.charAt(j));
                }
                start = indices.get(c) + 1;
                indices.put(c, i);
            }
        }

        return Math.max(maxLength, s.length() - start);
    }

    public static void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // "abc" -- 3
        System.out.println(lengthOfLongestSubstring("abcdcefcg")); // "abcd" or "efcg" -- 4
    }

    public static void main(String[] args) {
        test();
    }
}

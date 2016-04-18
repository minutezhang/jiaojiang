package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class WordPattern {
    /*
    Given a pattern and a string str, find if str follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in
    str.

    Examples:

        pattern = "abba", str = "dog cat cat dog" should return true.
        pattern = "abba", str = "dog cat cat fish" should return false.
        pattern = "aaaa", str = "dog cat cat dog" should return false.
        pattern = "abba", str = "dog dog dog dog" should return false.

    Notes:
    You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single
    space.
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> rmap = new HashMap<String, Character>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, words[i]);
            } else if (!map.get(c).equals(words[i])) {
                return false;
            }

            if (!rmap.containsKey(words[i])) {
                rmap.put(words[i], c);
            } else if (rmap.get(words[i]) != c) {
                return false;
            }
        }

        return true;
    }
}

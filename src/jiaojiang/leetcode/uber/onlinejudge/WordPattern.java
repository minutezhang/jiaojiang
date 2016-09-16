package jiaojiang.leetcode.uber.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 *
 * Created on Sep 12, 2016
 */
public class WordPattern {
    /*
    Given a pattern and a string str, find if str follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word
    in str.

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
        String[] strs = str.split("\\s+");
        if (pattern.length() != strs.length) {
            return false;
        }

        Map<Character, String> charStringMap = new HashMap<Character, String>();
        Map<String, Character> stringCharMap = new HashMap<String, Character>();

        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String word = charStringMap.get(c);
            if (word == null) {
                charStringMap.put(c, strs[i]);
            } else if (!word.equals(strs[i])) {
                return false;
            }

            Character character = stringCharMap.get(strs[i]);
            if (character == null) {
                stringCharMap.put(strs[i], c);
            } else if (c != character) {
                return false;
            }
        }

        return true;
    }
}

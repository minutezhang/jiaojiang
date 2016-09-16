package jiaojiang.leetcode.uber.onlinejudge;

import java.util.Map;
import java.util.HashMap;

/**
 * @author zhang
 *
 * Created on Sep 12, 2016
 */
public class WordPatternII {
    /*
    Given a pattern and a string str, find if str follows the same pattern.
    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
    substring in str.
    Examples:

        pattern = "abab", str = "redblueredblue" should return true.
        pattern = "aaaa", str = "asdasdasdasd" should return true.
        pattern = "aabb", str = "xyzabcxzyabc" should return false.

    Notes:
    You may assume both pattern and str contains only lowercase letters.
     */
    public static boolean wordPatternMatch(String pattern, String str) {
        return wordPatternMatch(pattern, 0, str, 0, new HashMap<Character, String>(), new HashMap<String, Character>());
    }

    private static boolean wordPatternMatch(String pattern, int pIdx, String str, int sIdx,
                                            Map<Character, String> char2StringMap, Map<String, Character> string2CharMap) {
        if (pIdx == pattern.length()) {
            return sIdx == str.length();
        }

        char c = pattern.charAt(pIdx);
        String word = char2StringMap.get(c);

        if (word != null) {
            if (str.substring(sIdx).startsWith(word)) {
                return wordPatternMatch(pattern, pIdx + 1, str, sIdx + word.length(), char2StringMap, string2CharMap);
            }
            return false;
        }

        for (int i = 1; i + sIdx < str.length(); i++) {
            String subString = str.substring(sIdx, i + sIdx);
            if (!string2CharMap.containsKey(subString)) {
                char2StringMap.put(c, subString);
                string2CharMap.put(subString, c);
                if (wordPatternMatch(pattern, pIdx + 1, str, sIdx + i, char2StringMap, string2CharMap)) {
                    return true;
                }
                char2StringMap.remove(c);
                string2CharMap.remove(subString);
            }
        }
        
        return false;
    }
}

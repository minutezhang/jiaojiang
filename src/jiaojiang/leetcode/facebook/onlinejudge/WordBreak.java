package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.Set;

/**
 * @author zhang
 *
 * Created on Aug 31, 2016
 */
public class WordBreak {
    /*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
    of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
     */

    public static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] isBreakable = new boolean[s.length() + 1];
        isBreakable[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < isBreakable.length; j++) {
                if (wordDict.contains(s.substring(i, j)) && isBreakable[j]) {
                    isBreakable[i] = true;
                    break;
                }
            }
        }

        return isBreakable[0];
    }

    public static boolean wordBreakRecursive(String s, Set<String> wordDict) {
        return wordBreakRecursive(s, 0, wordDict);
    }

    private static boolean wordBreakRecursive(String s, int start, Set<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) && wordBreakRecursive(s, i, wordDict)) {
                return true;
            }
        }
        return false;
    }
}

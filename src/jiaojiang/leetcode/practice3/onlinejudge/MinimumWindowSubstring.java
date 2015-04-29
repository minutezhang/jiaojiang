package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mizhang
 * @time: 2/5/15 9:24 PM
 */
public class MinimumWindowSubstring {
    /*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".

    Note:
    If there is no such window in S that covers all characters in T, return the emtpy string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     */
    public static String minWindow(String S, String T) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();

        for (int i = 0; i < T.length(); i++) {
            if (counts.containsKey(T.charAt(i))) {
                counts.put(T.charAt(i), counts.get(T.charAt(i)) + 1);
            } else {
                counts.put(T.charAt(i), 1);
            }
        }

        int minStart = 0, minEnd = S.length() - 1, totalCount = T.length();

        for (int start = 0, end = 0; end < S.length(); end++) {
            if (counts.containsKey(S.charAt(end))) {
                int count;
                if ((count = counts.get(S.charAt(end))) > 0) {
                    totalCount--;
                }
                counts.put(S.charAt(end), count - 1);
                if (totalCount == 0) {
                    while (!counts.containsKey(S.charAt(start)) || counts.get(S.charAt(start)) < 0) {
                        if (counts.containsKey(S.charAt(start))) {
                            counts.put(S.charAt(start), counts.get(S.charAt(start)) + 1);
                        }
                        start++;
                    }
                    if (end - start < minEnd - minStart) {
                        minStart = start;
                        minEnd = end;
                    }
                }
            }
        }

        return totalCount > 0 ? "" : S.substring(minStart, minEnd + 1);
    }
}
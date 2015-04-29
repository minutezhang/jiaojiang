package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Map;
import java.util.HashMap;

/**
 * @author: zhang
 * @since: May 9, 2013 11:05:04 PM
 */
public class MinWindowSubstring {
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
        Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>();

        int totalCount = 0, start = 0, end = 0, minStart = 0, minEnd = 0, minLenth = Integer.MAX_VALUE;

        for (char c : T.toCharArray()) {
            if (needToFind.containsKey(c)) {
                needToFind.put(c, needToFind.get(c) + 1);
            } else {
                hasFound.put(c, 0);
                needToFind.put(c, 1);
            }
        }

        while (end < S.length()) {
            if (needToFind.containsKey(S.charAt(end))) {
                hasFound.put(S.charAt(end), hasFound.get(S.charAt(end)) + 1);
                if (hasFound.get(S.charAt(end)) <= needToFind.get(S.charAt(end))) {
                    totalCount++;
                }

                if (totalCount == T.length()) {
                    while (!needToFind.containsKey(S.charAt(start)) || hasFound.get(S.charAt(start)) > needToFind.get(S.charAt(start))) {
                        if (needToFind.containsKey(S.charAt(start))) {
                            hasFound.put(S.charAt(start), hasFound.get(S.charAt(start)) - 1);
                        }
                        start++;
                    }

                    if (end - start < minLenth) {
                        minStart = start;
                        minEnd = end;
                        minLenth = minEnd - minStart;
                    }
                }
            }
            end++;
        }

        return totalCount < T.length() ? "" : S.substring(minStart, minEnd + 1);
    }

    public static void test() {
        System.out.println(minWindow("adobecodebanc", "abc"));     //banc
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));     //cwae
        System.out.println(minWindow("ab", "b"));     //b
        System.out.println(minWindow("bba", "ab"));     //ba

    }

    public static void main(String[] args) {
        test();
    }
}

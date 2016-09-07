package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class MinimumWindowSubstring {
    /*
     Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
     complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"

    Minimum window is "BANC".

    Note:
    If there is no such window in S that covers all characters in T, return the empty string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in
    S.
     */
    public static String minWindow(String s, String t) {
        int[] counts = new int[256];

        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i)]++;
        }

        int count = t.length(), startMin = 0, endMin = Integer.MAX_VALUE, start, end;
        for (start = 0, end = 0; end < s.length(); end++) {
            if (--counts[s.charAt(end)] >= 0) {
                count = Math.max(0, count - 1);
            }

            if (count == 0) {
                for(; start <= end && counts[s.charAt(start)] < 0; counts[s.charAt(start++)]++);
                if (end - start < endMin - startMin) {
                    endMin = end;
                    startMin = start;
                }
            }
        }

        return endMin == Integer.MAX_VALUE ? "" : s.substring(startMin, endMin + 1);
    }
}

package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 *
 * Created on Mar 7, 2016
 */
public class IsomorphicStrings {
    /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character but a character may map to itself.

    For example,
    Given "egg", "add", return true.

    Given "foo", "bar", return false.

    Given "paper", "title", return true.
     */
    public static boolean isIsomorphic(String s, String t) {
        char[] map = new char[256];
        char[] rMap = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (map[charS] == 0) {
                map[charS] = charT;
            } else if (map[charS] != charT) {
                return false;
            }

            if (rMap[charT] == 0) {
                rMap[charT] = charS;
            } else if (rMap[charT] != charS) {
                return false;
            }
        }

        return true;
    }
}

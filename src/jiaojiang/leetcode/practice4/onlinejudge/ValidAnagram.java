package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 15, 2016
 */
public class ValidAnagram {
    /*
    Given two strings s and t, write a function to determine if t is an anagram of s.

    For example,
    s = "anagram", t = "nagaram", return true.
    s = "rat", t = "car", return false.

    Note:
    You may assume the string contains only lowercase alphabets.

    Follow up:
    What if the inputs contain unicode characters? How would you adapt your solution to such case?
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] occurences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            occurences[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (occurences[t.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }

        return true;
    }
}

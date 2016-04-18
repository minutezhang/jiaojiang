package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.*;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class PalindromePairs {
    /*
     Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the
     concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

    Example 1:
    Given words = ["bat", "tab", "cat"]
    Return [[0, 1], [1, 0]]
    The palindromes are ["battab", "tabbat"]

    Example 2:
    Given words = ["abcd", "dcba", "lls", "s", "sssll"]
    Return [[0, 1], [1, 0], [3, 2], [2, 4]]
    The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
     */
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    ret.add(Arrays.asList(new Integer[]{i, j}));
                }
                if (isPalindrome(words[j] + words[i])) {
                    ret.add(Arrays.asList(new Integer[]{j, i}));
                }
            }
        }

        return ret;
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length >> 1; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }

        
        


        return ret;
    }

    private static String reverse(String s) {
        return reverse(s, 0, s.length());
    }

    private static String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = end - 1; i >= start; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

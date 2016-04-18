package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Mar 27, 2016
 */
public class RemoveDuplicateLetters {
    /*
     Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once
     and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

    Example:

    Given "bcabc"
    Return "abc"

    Given "cbacdcbc"
    Return "acdb"
     */
    public static String removeDuplicateLetters(String s) {
        boolean[] notReadable = new boolean[26];
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i = removeDuplicateLetters(s, i, notReadable, ret) + 1);

        return ret.toString();
    }

    private static int removeDuplicateLetters(String s, int start, boolean[] notReadable, StringBuilder ret) {
        int[] count = new int[26];
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!notReadable[c - 'a']) {
                count[c - 'a']++;
            }
        }

        int minIndex = s.length();
        char minChar = 255;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!notReadable[c - 'a']) {
                if (minChar > c) {
                    minChar = c;
                    minIndex = i;
                }

                if (count[c - 'a'] == 1) {
                    break;
                } else {
                    count[c - 'a']--;
                }
            }
        }

        if (minChar != 255) {
            ret.append(minChar);
            notReadable[minChar - 'a'] = true;
        }
        
        return minIndex;
    }

    public static String removeDuplicateLetters2(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[26];
        boolean[] isInStack = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i), cInStack;

            if (!isInStack[c - 'a']) {
                while (!stack.isEmpty() && (cInStack = stack.peek()) > c && count[cInStack - 'a'] > 0) {
                    stack.pop();
                    isInStack[cInStack - 'a'] = false;
                }
                stack.push(c);
                isInStack[c - 'a'] = true;
            }
            count[c - 'a']--;
        }

        String ret = "";
        while (!stack.isEmpty()) {
            ret = stack.pop() + ret;
        }

        return ret;
    }
}

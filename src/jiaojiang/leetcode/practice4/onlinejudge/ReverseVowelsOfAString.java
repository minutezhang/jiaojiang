package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Apr 25, 2016
 */
public class ReverseVowelsOfAString {
    /*
    Write a function that takes a string as input and reverse only the vowels of a string.

    Example 1:
    Given s = "hello", return "holle".

    Example 2:
    Given s = "leetcode", return "leotcede".
     */
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        for (int start = 0, end = chars.length - 1; start < end; start++, end--) {
            for(; start < end && !isVowel(chars[start]); start++);
            for(; start < end && !isVowel(chars[end]); end--);
            swap(chars, start, end);
        }

        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static void swap(char[] chars, int i, int j) {
        if (i == j) {
            return;
        }
        chars[i] ^= chars[j];
        chars[j] ^= chars[i];
        chars[i] ^= chars[j];
    }
}

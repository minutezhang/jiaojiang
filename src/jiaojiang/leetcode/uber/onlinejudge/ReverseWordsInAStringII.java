package jiaojiang.leetcode.uber.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 15, 2016
 */
public class ReverseWordsInAStringII {
    /*
    Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces and the words are always separated by a single space.
    For example,
    Given s = "the sky is blue",
    return "blue is sky the".
    Could you do it in-place without allocating extra space?
     */
    public static void reverseWords(char[] s) {
        for (int i = 0, j = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, j, i - 1);
                j = i + 1;
            }
        }
        reverse(s, 0, s.length - 1);
    }

    private static void reverse(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
}

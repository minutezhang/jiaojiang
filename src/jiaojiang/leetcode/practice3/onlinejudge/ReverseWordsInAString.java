package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/9/15 10:32 PM
 */
public class ReverseWordsInAString {
    /*
    Given an input string, reverse the string word by word.

    For example,
    Given s = "the sky is blue",
    return "blue is sky the".

    click to show clarification.

    Clarification:
    * What constitutes a word?
    A sequence of non-space characters constitutes a word.
    * Could the input string contain leading or trailing spaces?
    Yes. However, your reversed string should not contain leading or trailing spaces.
    * How about multiple spaces between two words?
    Reduce them to a single space in the reversed string.
     */

    public static String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();

        int start, end;
        for (start = s.length() - 1, end = s.length(); start >= -1; start--) {
            if (start == -1 || s.charAt(start) == ' ') {
                if (end - start >= 2) {
                    ret.append(s.substring(start + 1, end)).append(' ');
                }
                end = start;
            }
        }

        ret.setLength(Math.max(0, ret.length() - 1));

        return ret.toString();
    }
}

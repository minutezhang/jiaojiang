package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/28/15 6:37 PM
 */
public class LengthOfLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
    word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example,
    Given s = "Hello World",
    return 5.
     */
    public static int lengthOfLastWord(String s) {
        int lengthOfWord = 0, index;

        for(index = s.length() - 1; index >= 0 && s.charAt(index) == ' '; index--);
        for(; index>= 0 && s.charAt(index) != ' '; index--, lengthOfWord++);

        return lengthOfWord;
    }
}

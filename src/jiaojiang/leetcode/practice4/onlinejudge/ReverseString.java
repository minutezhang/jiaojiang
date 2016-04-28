package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Apr 22, 2016
 */
public class ReverseString {
    /*
    Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".
     */
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

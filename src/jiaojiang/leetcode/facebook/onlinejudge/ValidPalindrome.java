package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 31, 2016
 */
public class ValidPalindrome {
    /*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.

    For the purpose of this problem, we define empty string as valid palindrome.
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            for (; start < end && !isAlphaNumeric(s.charAt(start)) ; start++);
            for (; start < end && !isAlphaNumeric(s.charAt(end)); end--);
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return c >= 'a' && c <= 'z'
                || c >= 'A' && c <= 'Z'
                || c >= '0' && c <= '9';
    }
}

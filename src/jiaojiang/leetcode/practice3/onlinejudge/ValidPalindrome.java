package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/24/15 10:55 PM
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
        for (int i = 0, j = s.length() - 1; i < j;) {
            char si = s.charAt(i), sj = s.charAt(j);
            if (isAlphanumeric(si) && isAlphanumeric(sj)) {
                if (si != sj) {
                    return false;
                }
                i++;
                j--;
            } else if (isAlphanumeric(si)) {
                j--;
            } else if (isAlphanumeric(sj)) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return c <= 'z' && c >= 'a' || c <= '9' && c >= '0';
    }
}

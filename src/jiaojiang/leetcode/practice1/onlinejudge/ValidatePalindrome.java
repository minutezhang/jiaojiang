package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang
 * @since: Apr 25, 2013 10:48:19 AM
 */
public class ValidatePalindrome {
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
        String ls = s.toLowerCase();
        int i = 0, j = ls.length() - 1;

        while (i < j) {
            char ic = ls.charAt(i), jc = ls.charAt(j);
            while ( i < j && !(ic <= '9' && ic >= '0' || ic <= 'z' && ic >= 'a') ) {
                ic = ls.charAt(++i);
            }

            while (i < j && !(jc <= '9' && jc >= '0' || jc <= 'z' && jc >= 'a')) {
                jc = ls.charAt(--j);
            }

            if (ic != jc) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void test() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static void main(String[] args) {
        test();
    }
}

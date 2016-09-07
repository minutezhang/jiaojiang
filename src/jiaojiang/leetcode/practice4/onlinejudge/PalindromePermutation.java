package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Jul 10, 2016
 */
public class PalindromePermutation {
    /*
    Given a string, determine if a permutation of the string could form a palindrome.

    For example,
    "code" -> False, "aab" -> True, "carerac" -> True.

    Hint:
        Consider the palindromes of odd vs even length. What difference do you notice?
        Count the frequency of each character.
        If each character occurs even number of times, then it must be a palindrome. How about character which occurs
        odd number of times?
     */
    public static boolean canPermutePalindrome(String s) {
        boolean[] flag = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 'a'] = !flag[s.charAt(i) - 'a'];
        }
        int count = 0;
        for (boolean f : flag) {
            if (f) {
                count++;
            }
        }
        return count <= 1;
    }
}

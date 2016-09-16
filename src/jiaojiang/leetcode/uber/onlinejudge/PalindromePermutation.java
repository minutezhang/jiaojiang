package jiaojiang.leetcode.uber.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 13, 2016
 */
public class PalindromePermutation {
    /*
    Given a string, determine if a permutation of the string could form a palindrome.
    For example,
    "code" -> False, "aab" -> True, "carerac" -> True.
     */
    public static boolean canPermutePalindrome(String s) {
        s = s.toLowerCase();

        int[] counts = new int[256];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        // no need to check the length of the string
        int oddCount = 0;
        for (int c : counts) {
            if ((c & 1) != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/27/15 2:54 PM
 */
public class PalindromePartitioningII {
    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return the minimum cuts needed for a palindrome partitioning of s.

    For example, given s = "aab",
    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */
    public static int minCut(String s) {
        int[] minCuts = new int[s.length()];
        boolean[] isPalindrome = new boolean[s.length()]; //whether isPalindrome[j] means s[j] to current i (iteration) is palindrom

        minCuts[0] = 0;
        isPalindrome[0] = true;

        for (int i = 1; i < s.length(); i++) {
            isPalindrome[i] = true;
            minCuts[i] = minCuts[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if(isPalindrome[j] = isPalindrome[j + 1] && s.charAt(i) == s.charAt(j)) {
                    minCuts[i] = Math.min(minCuts[i], j == 0 ? 0 : minCuts[j - 1] + 1);
                }
            }
        }

        return minCuts[s.length() - 1];
    }
}

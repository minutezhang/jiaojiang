package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author zhang
 * @since: Sep 24, 2013 2:18:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitionII {
    /*Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s = "aab",
     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
    */
    public static int minCut(String s) {
        return minCut(s, 0);
    }

    public static int minCut(String s, int start) {
        int minCut = Integer.MAX_VALUE;
        if (start == s.length()) {
            return -1;
        }

        for (int i = start; i < s.length(); i++) {
            int cut;
            if (isPalindrome(s, start, i) && (cut = minCut(s, i + 1)) != Integer.MAX_VALUE) {
                minCut = Math.min(cut + 1, minCut);
            }
        }

        return minCut;
    }

    public static int minCutDP(String s) {
        int[] minCut = new int[s.length() + 1];
        //isPalindrome array is used to check whether the substring from char i to the current char is a palindrome,
        //which could be done by DP. Please note, in each iteration, all the value could be different. At iteration j,
        //only first j elements are useful
        boolean[] isPalindrome = new boolean[s.length()];

        minCut[0] = -1;
        isPalindrome[0] = true;

        for (int i = 1; i < minCut.length; i++) {
            int min = minCut[i - 1] + 1;
            isPalindrome[i - 1] = true;
            for (int j = 0; j < i - 1; j++) {
                if (isPalindrome[j + 1] && s.charAt(j) == s.charAt(i - 1)) {
                    isPalindrome[j] = true;
                    min = Math.min(min, minCut[j] + 1);
                } else {
                    isPalindrome[j] = false;
                }
            }
            minCut[i] = min;
        }

        return minCut[minCut.length - 1];
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (; start < end && s.charAt(start) == s.charAt(end); start++, end--);
        return start >= end;
    }

    public static void test() {
        Utils.printTestln(minCut("aab"), 1);
        Utils.printTestln(minCut("ab"), 1);
        Utils.printTestln(minCut("cabababcbc"), 3);
//        Utils.printTestln(minCut("ababababababababababababcbabababababababababababa"), 0);
        
        Utils.printTestln(minCutDP("aab"), 1);
        Utils.printTestln(minCutDP("ab"), 1);
        Utils.printTestln(minCutDP("cabababcbc"), 3);
        Utils.printTestln(minCutDP("ababababababababababababcbabababababababababababa"), 0);
    }

    public static void main(String[] args) {
        test();
    }
}

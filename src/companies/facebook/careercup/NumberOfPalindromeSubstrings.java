package companies.facebook.careercup;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 5, 2014 3:09:10 PM
 */
public class NumberOfPalindromeSubstrings {
    /*
    Write a function for retrieving the total number of substring palindromes.
    For example the input is 'abba' then the possible palindromes= a, b, b, a, bb, abba
    So the result is 6.

    Updated at 11/11/2013:
    After the interview I got know that the O(n^3) solution is not enough to go to the next round. It would have been
    better to know before starting implementing the solution unnecessarily ...
     */
    public static int numPalindromeSubstring(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrom(s, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    // end is inclusive
    private static boolean isPalindrom(String s, int start, int end) {
        for (; start < end && s.charAt(start) == s.charAt(end); start++, end--);
        return start >= end;
    }

    public static int numPalindromeSubstringDP(String s) {
        int count = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];

        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = true;
            dp[i][i - 1] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if(s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                    count++;
                }
            }
        }
        
        return count;
    }

    private static void test() {
        Utils.printTestln(numPalindromeSubstring("abba"), 6);
        Utils.printTestln(numPalindromeSubstring("cabababcbc"), 18);
        Utils.printTestln(numPalindromeSubstring("ababababababababababababcbabababababababababababa"), 337);

        Utils.printTestln(numPalindromeSubstringDP("abba"), 6);
        Utils.printTestln(numPalindromeSubstringDP("cabababcbc"), 18);
        Utils.printTestln(numPalindromeSubstringDP("ababababababababababababcbabababababababababababa"), 337);
    }

    public static void main(String[] args) {
        test();
    }
}

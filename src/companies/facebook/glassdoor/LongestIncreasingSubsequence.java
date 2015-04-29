package companies.facebook.glassdoor;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 8, 2014 3:17:44 PM
 */
public class LongestIncreasingSubsequence {
    /*
    The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given
    sequence such that all elements of the subsequence are sorted in increasing order.  For example, length of LIS
    for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
     */
    public static int getLIS(int[] data) {
        int[] dp = new int[data.length];
        int max = 0;

        dp[data.length - 1] = 1;
        for (int i = data.length - 2, j; i >= 0; i--) {
            for (j = i + 1; j < data.length; j++) {
                if (data[i] < data[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    private static void test() {
        Utils.printTestln(getLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}), 6);
        Utils.printTestln(getLIS(new int[]{3, 1, 2, 5, 4}), 3);
        Utils.printTestln(getLIS(new int[]{8, 1, 2, 3, 0, 5}), 4);
    }

    public static void main(String[] args) {
        test();
    }
}

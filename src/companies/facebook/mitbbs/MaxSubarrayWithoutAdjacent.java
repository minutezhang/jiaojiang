package companies.facebook.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 3, 2014 8:58:13 PM
 */
public class MaxSubarrayWithoutAdjacent {
    /*
    Given a non negetive integer array, find a subset of this array such that no any 2 elements in the subset is adjacent
    to each other (begin and end do not count) and the sum is maximized
     */
    public static int maxSum(int[] data) {
        return maxSum(data, 0);
    }

    private static int maxSum(int[] data, int start) {
        if (start >= data.length) {
            return 0;
        }
        return Math.max(data[start] + maxSum(data, start + 2), maxSum(data, start + 1)); 
    }

    public static int maxSumDP(int[] data) {
        int[] dp = new int[data.length + 1];
        dp[data.length] = 0;
        dp[data.length - 1] = data[data.length - 1];

        for (int i = data.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], data[i] + dp[i + 2]);
        }

        return dp[0];
    }

    public static int maxSumDP2(int[] data) {
        int dp0 = data[0], dp1 = data[data.length - 1], dp2 = 0;

        for (int i = data.length - 2; i >= 0; i--) {
            dp0 = Math.max(dp1, data[i] + dp2);
            dp2 = dp1;
            dp1 = dp0;
        }

        return dp0;
    }


    private static void test() {
        Utils.printTestln(maxSum(new int[]{1, 7, 4, 0, 9, 4, 8, 8}), 24);
        Utils.printTestln(maxSum(new int[]{1, 12, 13, 4, 5, 6, 7}), 26);

        Utils.printTestln(maxSumDP(new int[]{1, 7, 4, 0, 9, 4, 8, 8}), 24);
        Utils.printTestln(maxSumDP(new int[]{1, 12, 13, 4, 5, 6, 7}), 26);

        Utils.printTestln(maxSumDP2(new int[]{1, 7, 4, 0, 9, 4, 8, 8}), 24);
        Utils.printTestln(maxSumDP2(new int[]{1, 12, 13, 4, 5, 6, 7}), 26);
        Utils.printTestln(maxSumDP2(new int[]{1, 2, 2, 2, 9}), 12);
        Utils.printTestln(maxSumDP2(new int[]{1, 2, 2, 2, 0}), 4);
        Utils.printTestln(maxSumDP2(new int[]{1, 4, 0, -2, 9, 8}), 13);
        Utils.printTestln(maxSumDP2(new int[]{1, -2, 3, 5, -1, 2}), 8);
    }

    public static void main(String[] args) {
        test();
    }
}

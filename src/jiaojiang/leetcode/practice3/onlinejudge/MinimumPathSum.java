package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/4/15 1:20 PM
 */
public class MinimumPathSum {

    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
    sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[n - 1] = grid[m - 1][n - 1];

        for(int i = n - 2; i >= 0; i--) {
            dp[i] = grid[m - 1][i] + dp[i + 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = grid[i][n - 1] + dp[n - 1];
            for(int j = n - 2; j >= 0; j--) {
                dp[j] = grid[i][j] + Math.min(dp[j + 1], dp[j]);
            }
        }

        return dp[0];
    }
}

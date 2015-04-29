package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 28, 2015 3:50:24 PM
 */
public class UniquePaths {
    /*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
    corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?


    Above is a 3 x 7 grid. How many possible unique paths are there?

    Note: m and n will be at most 100.
     */
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1); 
    }

    public static int uniquePathsDP(int m, int n) {
        if (m < n) {
            return uniquePathsDP(n, m);
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}

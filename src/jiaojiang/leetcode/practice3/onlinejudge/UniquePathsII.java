package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 28, 2015 4:07:50 PM
 */
public class UniquePathsII {
    /*
    Follow up for "Unique Paths":

    Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    For example,

    There is one obstacle in the middle of a 3x3 grid as illustrated below.

    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]

    The total number of unique paths is 2.

    Note: m and n will be at most 100.
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j) {

        if (i == obstacleGrid.length || j == obstacleGrid[0].length) {
            return 0;
        }

        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }

        return uniquePathsWithObstacles(obstacleGrid, i + 1, j) + uniquePathsWithObstacles(obstacleGrid, i, j + 1);
    }

    public static int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[] dp = new int[n];
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = obstacleGrid[m - 1][i] == 0 ? dp[i + 1] : 0;
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = obstacleGrid[i][n - 1] == 0 ? dp[n - 1] : 0;
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = obstacleGrid[i][j] == 0 ? dp[j + 1] + dp[j]: 0;
            }
        }

        return dp[0];
    }
}

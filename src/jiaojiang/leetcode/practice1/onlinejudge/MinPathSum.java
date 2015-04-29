package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 30, 2013 8:37:03 PM
 */
public class MinPathSum {
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time
     */
    public static int minPathSum(int[][] grid) {
        return minPathSum(grid, 0, 0);
    }

    public static int minPathSum(int[][] grid, int m, int n) {
        if (m == grid.length - 1 &&  n == grid[0].length - 1) {
            return grid[m][n];
        }

        if (m == grid.length || n == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        return grid[m][n] + Math.min(minPathSum(grid, m + 1, n), minPathSum(grid, m, n + 1));
    }

    public static int minPathSumDP(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];

        sum[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sum[m - 1][i] = grid[m - 1][i] + sum[m - 1][i + 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            sum[i][n - 1] = grid[i][n - 1] + sum[i + 1][n - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                sum[i][j] = grid[i][j] + Math.min(sum[i + 1][j], sum[i][j + 1]);
            }
        }

        return sum[0][0];
    }

    public static int[][] getGrid() {
        return new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
    }

    public static void test() {
        System.out.println(minPathSum(getGrid())); //7
        System.out.println(minPathSumDP(getGrid()));  //7
    }

    public static void main(String[] args) {
        test();
    }
}

package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 29, 2013 11:56:36 PM
 */
public class UniquePaths {
    /*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

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
        int[][] paths = new int[m][n];

        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] =  paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void test() {
        System.out.println(uniquePaths(6, 4)); //56
        System.out.println(uniquePathsDP(6, 4)); //56
    }

    public static void main(String[] args) {
        test();
    }
}

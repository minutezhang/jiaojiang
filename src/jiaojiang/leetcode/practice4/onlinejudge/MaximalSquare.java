package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 10, 2016
 */
public class MaximalSquare {
    /*
     Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

    For example, given the following matrix:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0

    Return 4.
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int maxLength = 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int length = dp[i][j], ii, jj;
                for (ii = 0; ii < length + 1 && matrix[i - ii][j] == '1'; ii++);
                for (jj = 0; jj < ii && matrix[i][j - jj] == '1'; jj++);
                dp[i + 1][j + 1] = jj;
                maxLength = Math.max(dp[i + 1][j + 1], maxLength);
            }
        }

        return maxLength * maxLength;
    }
}

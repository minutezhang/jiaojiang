package jiaojiang.leetcode.practice5.onlinejudge;

public class DiagonalTraverse {
    /**
     * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
     *
     * Example 1:
     *
     * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,4,7,5,3,6,8,9]
     *
     * Example 2:
     *
     * Input: mat = [[1,2],[3,4]]
     * Output: [1,2,3,4]
     *
     *
     *
     * Constraints:
     *
     *     m == mat.length
     *     n == mat[i].length
     *     1 <= m, n <= 10^4
     *     1 <= m * n <= 10^4
     *     -105 <= mat[i][j]<= 10^5
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, index = 0;
        int[] ret = new int[m * n];
        for (int l = 0; l < m + n - 1; ++l) {
            if ((l & 1) == 0) {
                for (int i = Math.min(l, m - 1), j = l - i; i >= 0 && j < n; --i, ++j) {
                    ret[index++] = mat[i][j];
                }
            } else {
                for (int j = Math.min(l, n - 1), i = l - j; j >= 0 && i < m; ++i, --j) {
                    ret[index++] = mat[i][j];
                }
            }
        }
        return ret;
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 27, 2015 11:08:21 PM
 */
public class SetMatrixZeroes {
    /*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

    click to show follow up.
    Follow up:

    Did you use extra space?
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, rowIndex = -1, colIndex = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (rowIndex == -1 && colIndex == -1) {
                        rowIndex = i;
                        colIndex = j;
                    } else {
                        matrix[rowIndex][j] = 0;
                        matrix[i][colIndex] = 0;
                    }
                }
            }
        }

        if (rowIndex != -1 && colIndex != -1) {
            for (int i = 0; i < n; i++) {
                if (i != colIndex) {
                    if (matrix[rowIndex][i] == 0) {
                        for (int j = 0; j < m; j++) {
                            matrix[j][i] = 0;
                        }
                    } else {
                        matrix[rowIndex][i] = 0;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                if (i != rowIndex) {
                    if (matrix[i][colIndex] == 0) {
                        for (int j = 0; j < n; j++) {
                            matrix[i][j] = 0;
                        }
                    } else {
                        matrix[i][colIndex] = 0;
                    }
                }
            }
        }
    }
}

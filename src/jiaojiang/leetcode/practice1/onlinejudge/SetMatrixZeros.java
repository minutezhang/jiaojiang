package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class SetMatrixZeros {
    /*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place
     */

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int r = -1, c = 0;

        for (int i = 0; i < m && r == -1; i++) {
            for (int j = 0; j < n && r == -1; j++) {
                if (matrix[i][j] == 0) {
                    r = i;
                    c = j;
                }
            }
        }

        if (r == -1) {
            return;
        }

        for (int i = r; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[r][j] = 0;
                    matrix[i][c] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (i == r) {
                continue;
            }

            if (matrix[i][c] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            } else {
                matrix[i][c] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[r][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            } else {
                matrix[r][i] = 0;
            }
        }
    }

    public static void test() { // expect [[0,0,0,0],[0,0,0,4],[0,0,0,0],[0,0,0,3],[0,0,0,0]]
        int[][] matrix = new int[][] {
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}
        };

        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}

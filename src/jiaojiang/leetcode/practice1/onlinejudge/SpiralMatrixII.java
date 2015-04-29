package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 30, 2013 11:44:46 PM
 */
public class SpiralMatrixII {
    /*
    Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

    For example,
    Given n = 3,

    You should return the following matrix:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix  = new int[n][n];
        generateMatrix(matrix, 0, n, 1);

        return matrix;
    }

    public static void generateMatrix(int[][] matrix, int start, int end, int c) {
        if (start == end) {
            return;
        }

        int k = c;
        if (start == end - 1) {
            matrix[start][start] = k;
            return;
        }

        for (int i = start; i < end - 1; i++) {
            matrix[start][i] = k++;
        }

        for (int i = start; i < end -1; i++) {
            matrix[i][end - 1] = k++;
        }

        for (int i = end - 1; i > start; i--) {
            matrix[end - 1][i] = k++;
        }

        for (int i = end - 1; i > start; i--) {
            matrix[i][start] = k++;
        }

        generateMatrix(matrix, start + 1, end - 1, k);
    }

    public static void test() {
        for (int i = 0; i < 7; i++) {
            int[][] matrix = generateMatrix(i);
            System.out.println(matrix);
            for (int[] line : matrix) {
                for (int j : line) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        test();
    }
}

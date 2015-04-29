package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 30, 2013 10:38:36 PM
 */
public class SpiralMatrix {
    /*
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

     For example,
     Given the following matrix:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]

    You should return [1,2,3,6,9,8,7,4,5].
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return spiralOrder(matrix, 0, matrix.length, 0, 0);
        }
        return spiralOrder(matrix, 0, matrix.length, 0, matrix[0].length);
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix, int iStart, int iEnd, int jStart, int jEnd) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if (iStart == iEnd || jStart == jEnd) {
            return ret;
        }

        if (iStart == iEnd - 1) {
            for (int i = jStart; i < jEnd; i++) {
                ret.add(matrix[iStart][i]);
            }

            return ret;
        }

        if (jStart == jEnd - 1) {
            for (int i = iStart; i < iEnd; i++) {
                ret.add(matrix[i][jStart]);
            }

            return ret;
        }

        for (int i = jStart; i < jEnd - 1; i++) {
            ret.add(matrix[iStart][i]);
        }

        for (int i = iStart; i < iEnd - 1; i++) {
            ret.add(matrix[i][jEnd - 1]);
        }

        for (int i = jEnd - 1; i > jStart; i--) {
            ret.add(matrix[iEnd - 1][i]);
        }

        for (int i = iEnd - 1; i > iStart; i--) {
            ret.add(matrix[i][jStart]);
        }

        ret.addAll(spiralOrder(matrix, iStart + 1, iEnd - 1, jStart + 1, jEnd - 1));

        return ret;
    }


    public static int[][] getMatrix() {
        return new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9} };
    }

    public static void test() {        //1,2,3,6,9,8,7,4,5
        for (int i : spiralOrder(getMatrix())) {
            System.out.print(i +  " ");
        }
    }

    public static void main(String[] args) {
        test();
    }

}

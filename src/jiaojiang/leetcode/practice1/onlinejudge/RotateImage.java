package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 19, 2013 9:28:06 PM
 */
public class RotateImage {
    /*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up:
     Could you do this in-place?
     */

    //Solution: Rotation 90 degress: (i, j) --> (j, n - 1 - i) 
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                swap(matrix, i, j, j, matrix.length - 1 - i);
                swap(matrix, i, j, matrix.length - i - 1, matrix.length - 1 - j);
                swap(matrix, i, j, matrix.length - 1 - j, i);
            }
        }
    }

    public static void swap(int[][] matrix, int i, int j, int i2, int j2) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }

    public static void test() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        rotate(matrix);
        for (int[] line : matrix) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        //[
        // [21,16,11,6,1],
        // [22,17,12,7,2],
        // [23,18,13,8,3],
        // [24,19,14,9,4],
        // [25,20,15,10,5]
        // ]
    }

    public static void main(String[] args) {
         test();
    }
}

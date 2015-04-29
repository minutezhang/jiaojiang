package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 27, 2015 10:57:47 PM
 */
public class SearchA2DMatrix {
    /*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

    For example,

    Consider the following matrix:

    [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]

    Given target = 3, return true.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, start = 0, end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1, mmid = mid / n, nmid = mid % n;

            if (matrix[mmid][nmid] == target) {
                return true;
            }

            if (matrix[mmid][nmid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}

package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 15, 2013 10:13:06 PM
 */
public class Search2DMatrix {
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

    public static boolean binarySearch(int[] data, int target) {
        int start = 0, end = data.length - 1;
        while (start <= end) {
            int mid = ( start + end ) >>> 1;
            if (data[mid] == target) {
                return true;
            }

            if (data[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0 , end = matrix.length * matrix[0].length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;

            if (matrix[x][y] == target) {
                return true;
            }

            if (matrix[x][y] < target) {
                start = x * matrix[0].length + y + 1;
            } else {
                end = x * matrix[0].length + y - 1;
            }
        }

        return false;
    }

    public static int[] getIndices(int i, int m, int n) {
        return new int[]{i / m, i % n};
    }

    public static void test() {
        int[][] matrix  = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 6));
    }

    public static void main(String[] args) {
//        System.out.printTestln(binarySearch(new int[]{1, 3, 5, 7, 9, 10}, 11));
        test();

    }
}

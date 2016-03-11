package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Feb 29, 2016
 */
public class LongestIncreasingPathInAMatrix {
    /*
    Given an integer matrix, find the length of the longest increasing path.

    From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or
    move outside of the boundary (i.e. wrap-around is not allowed).

    Example 1:

    nums = [
      [9,9,4],
      [6,6,8],
      [2,1,1]
    ]

    Return 4
    The longest increasing path is [1, 2, 6, 9].

    Example 2:

    nums = [
      [3,4,5],
      [3,2,6],
      [2,2,1]
    ]

    Return 4
    The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
     */
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, longestIncreasingPath(i, j, Integer.MIN_VALUE, matrix, visited));
            }
        }
        return maxLength;
    }

    private static int longestIncreasingPath(int i, int j, int previous, int[][] matrix, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] <= previous) {
            return 0;
        }

        visited[i][j] = true;

        int length = 1 + Math.max(longestIncreasingPath(i - 1, j, matrix[i][j], matrix, visited),
                            Math.max(longestIncreasingPath(i, j + 1, matrix[i][j], matrix, visited),
                                Math.max(longestIncreasingPath(i + 1, j, matrix[i][j], matrix, visited),
                                    longestIncreasingPath(i, j - 1, matrix[i][j], matrix, visited))));

        visited[i][j] = false;
        return length;
    }

    public static int longestIncreasingPath2(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] lengths = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, longestIncreasingPath2(i, j, Integer.MIN_VALUE, matrix, visited, lengths));
            }
        }

        return maxLength;
    }

    private static int longestIncreasingPath2(int i, int j, int previous, int[][] matrix, boolean[][] visited, int[][] lengths) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] <= previous) {
            return 0;
        }

        if (lengths[i][j] == 0) {
            visited[i][j] = true;
            lengths[i][j] = 1 + Math.max(longestIncreasingPath2(i - 1, j, matrix[i][j], matrix, visited, lengths),
                                Math.max(longestIncreasingPath2(i, j + 1, matrix[i][j], matrix, visited, lengths),
                                    Math.max(longestIncreasingPath2(i + 1, j, matrix[i][j], matrix, visited, lengths),
                                        longestIncreasingPath2(i, j - 1, matrix[i][j], matrix, visited, lengths))));
            visited[i][j] = false;
        }

        return lengths[i][j];
    }
}

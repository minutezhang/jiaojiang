package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: May 8, 2013 1:57:46 PM
 */
public class MaxRectangle {
    /*
    Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
     */
    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxArea = Math.max(maxRecHelp(matrix, i, j), maxArea);
            }
        }

        return maxArea;
    }

    private static int maxRecHelp(char[][] matrix, int row, int column) {
        int lineMin = matrix[0].length, maxArea = 0, i = row;
        while (i < matrix.length && matrix[i][column] == '1') {
            int j = column;
            while(j < matrix[0].length && matrix[i][j] == '1') {
                j++;
            }
            lineMin = Math.min(lineMin, j - column);
            maxArea = Math.max((i - row + 1) * lineMin, maxArea);
            i++;
        }
        return maxArea;
    }

    public static int maximalRectangleDP(char[][] matrix) {
        return 0;
    }
    
    public static void test() {
        Utils.printTestln(maximalRectangle(new char[][] {
                "0010".toCharArray(),
                "1111".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray(),
                "1100".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray()}
        ), 12); //12

        Utils.printTestln(maximalRectangle(new char[][] {
                "01101".toCharArray(),
                "11010".toCharArray(),
                "01110".toCharArray(),
                "11110".toCharArray(),
                "11111".toCharArray(),
                "00000".toCharArray()}
        ), 9); //9
        
    }
    
    public static void main(String[] args) {
        test();
//        System.out.println(maxRecHelp(new char[][]{
//                "11100".toCharArray(),
//                "1100".toCharArray(),
//                "11100".toCharArray(),
//        }, 0, 0));
    }
}

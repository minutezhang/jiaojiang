package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Mar 22, 2015 7:54:09 PM
 */
public class NQueensII {
    /*
    Follow up for N-Queens problem.

    Now, instead outputting board configurations, return the total number of distinct solutions.
     */
    public static int totalNQueens(int n) {
        return totalNQueens(0, new int[n]);
    }

    private static int totalNQueens(int rowLevel, int[] rowColumnMap) {
        if (rowLevel == rowColumnMap.length) {
            return 1;
        }

        int totalCount = 0;
        for (int i = 0; i < rowColumnMap.length; i++) {
            if (isValidPosition(rowLevel, i, rowColumnMap)) {
                rowColumnMap[rowLevel] = i;
                totalCount += totalNQueens(rowLevel + 1, rowColumnMap);
            }
        }

        return totalCount;
    }

    private static boolean isValidPosition(int row, int column, int[] rowColumnMap) {
        for (int i = 0; i < row; i++) {
            if (row - i == column - rowColumnMap[i] || row - i == rowColumnMap[i] - column || column == rowColumnMap[i]) {
                return false;
            }
        }
        return true;
    }
}

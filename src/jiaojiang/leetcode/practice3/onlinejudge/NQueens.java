package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: zhang
 * @date: Mar 22, 2015 4:45:37 PM
 */
public class NQueens {
    /*
    The n-queens puzzle is the problem of placing n queens on an n?n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    For example,
    There exist two distinct solutions to the 4-queens puzzle:

    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
     */
    public static List<String[]> solveNQueens(int n) {
        List<String[]> ret = new ArrayList<String[]>();
        solveNQueens(0, new int[n], ret, getQueens(n));
        return ret;
    }

    private static void solveNQueens(int currentRow, int[] rowColumnMap, List<String[]> ret, String[] queens) {
        if (currentRow == rowColumnMap.length) {
            arrange(rowColumnMap, ret, queens);
            return;
        }

        for (int i = 0; i < rowColumnMap.length; i++) {
            if (validPosition(currentRow, i, rowColumnMap)) {
                rowColumnMap[currentRow] = i;
                solveNQueens(currentRow + 1, rowColumnMap, ret, queens);
            }
        }
    }

    private static boolean validPosition(int row, int column, int[] rowColumnMap) {
        for (int i = 0; i < row; i++) {
            if (row - i == rowColumnMap[i] - column || row - i == column - rowColumnMap[i] || column == rowColumnMap[i]) {
                return false;
            }
        }
        return true;
    }

    private static void arrange(int[] rowColumnMap, List<String[]> ret, String[] queens){
        String[] solution = new String[rowColumnMap.length];
        for (int i : rowColumnMap) {
            solution[i] = queens[rowColumnMap[i]];
        }

        ret.add(solution);
    }

    private static String[] getQueens(int n) {
        String[] queens = new String[n];
        char[] chars = new char[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[j] = i != j ? '.' : 'Q';
            }
            queens[i] = new String(chars);
        }

        return queens;
    }
}

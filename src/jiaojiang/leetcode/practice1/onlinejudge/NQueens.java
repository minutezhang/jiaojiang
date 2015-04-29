package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @since: Apr 30, 2013 9:47:29 PM
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
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }

        solveNQueens(board, n, 0, ret);

        return ret;
    }

    public static void solveNQueens(char[][] board, int n, int level, List<String[]> ret) {
        if (level == n) {
            String[] boardStr = new String[board.length];
            for (int i = 0; i < board.length; i++) {
                boardStr[i] = new String(board[i]);
            }
            ret.add(boardStr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isOK(board, level, i)) {
                board[level][i] = 'Q';
                solveNQueens(board, n, level + 1, ret);
                board[level][i] = '.';
            }
        }
    }

    public static boolean isOK(char[][] board, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 'Q') {
                return false;
            }
        }

        for (int k = i, l = j; k >= 0 && l < board.length; k--, l++) {
            if (board[k][l] == 'Q') {
                return false;
            }
        }

        for (int k = i, l = j; k >= 0 && l >= 0 ; k--, l--) {
            if (board[k][l] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void test() {
        for (String[] ss : solveNQueens(4)) {
            for (String s : ss) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}

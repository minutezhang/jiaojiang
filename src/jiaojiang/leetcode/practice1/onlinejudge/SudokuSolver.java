package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.List;

/**
 * @author: zhang
 * @since: May 20, 2013 5:16:56 PM
 */
public class SudokuSolver {
    /*
    Write a program to solve a Sudoku puzzle by filling the empty cells.

    Empty cells are indicated by the character '.'.

    You may assume that there will be only one unique solution.



    A sudoku puzzle...



    ...and its solution numbers marked in red.
     */
    public static void solveSudoku(char[][] board) {


    }

    public static List<Integer> getCandidate(char[][] board, int i, int j) {
        boolean[] doesExistBlock = new boolean[9];
        boolean[] doesExistRow = new boolean[9];
        boolean[] doesExistColumn = new boolean[9];

        int blockRow = (i / 3) * 3, blockColumn = (j / 3) * 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[blockRow + k][blockColumn + l] == '.') {
                    continue;
                }

                if (doesExistBlock[board[blockRow + i][blockColumn + j] - '0']) {
                    return null;
                }
                
                doesExistBlock[board[blockRow + i][blockColumn + j] - '0'] = false;
            }
        }

        for (int k = 0; k < 9; k++) {
            if (board[k][j] != '.' && doesExistColumn[board[k][j] - '0']) {
                return null;
            }
            doesExistColumn[board[k][j]-  '0'] = true;

            if (board[i][k] != '.' &&  doesExistRow[board[i][k] - '0']) {
                return null;
            }
            doesExistRow[board[k][j]-  '0'] = true;
        }
        
        for (int k = 0; k < 9; k++) {
            
        }

        return null;
    }

    public static void test() {

    }

    public static void main(String[] args) {
        test();
    }
}

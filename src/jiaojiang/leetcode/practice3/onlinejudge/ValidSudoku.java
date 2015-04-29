package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/10/15 11:34 AM
 */
public class ValidSudoku {
    /*
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


    A partially filled sudoku which is valid.

    Note:
    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
     */
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isRowValid(board, i) || !isColumnValid(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (! isBlockValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isRowValid(char[][] board, int i) {
        boolean[] exist = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.') {
                if (exist[board[i][j] - '1']) {
                    return false;
                }
                exist[board[i][j] - '1'] = true;
            }
        }

        return true;
    }

    private static boolean isColumnValid(char[][] board, int i) {
        boolean[] exist = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (board[j][i] != '.') {
                if (exist[board[j][i] - '1']) {
                    return false;
                }
                exist[board[j][i] - '1'] = true;
            }
        }

        return true;
    }

    private static boolean isBlockValid(char[][] board, int i, int j) {
        boolean[] exist = new boolean[9];
        for(int k = i * 3; k < (i + 1) * 3; k++) {
            for (int l = j * 3; l < (j + 1) * 3; l++) {
                if (board[k][l] != '.') {
                    if (exist[board[k][l] - '1']) {
                        return false;
                    }
                    exist[board[k][l] - '1'] = true;
                }
            }
        }

        return true;
    }
}

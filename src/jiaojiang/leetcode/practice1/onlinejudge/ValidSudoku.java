package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 6, 2013 8:42:34 PM
 */
public class ValidSudoku {
    /*
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    A partially filled sudoku which is valid.
     */
    public static boolean isValidSudoku(char[][] board) {
        boolean[] exist = new boolean[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                exist[j] = false;
            }

            for (int j = 0; j < 9; j++) {
                if (board[i][j] - '1' < 0 || board[i][j] - '1' > 9) {
                    continue;
                }
                if (exist[board[i][j] - '1'] == true) {
                    return false;
                } else {
                    exist[board[i][j] - '1'] = true;
                }
            }

            for (int j = 0; j < 9; j++) {
                exist[j] = false;
            }

            for (int j = 0; j < 9; j++) {
                if (board[j][i] - '1' < 0 || board[j][i] - '1' > 9) {
                    continue;
                }
                if (exist[board[j][i] - '1'] == true) {
                    return false;
                } else {
                    exist[board[j][i] - '1'] = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int m = 0; m < 9; m++) {
                        exist[m] = false;
                    }
                for (int k = i * 3; k < (i + 1) * 3; k++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        if (board[k][l] - '1' < 0 || board[k][l] - '1' > 9) {
                           continue;
                        }
                        if (exist[board[k][l] - '1'] == true) {
                            return false;
                        } else {
                            exist[board[k][l] - '1'] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
    
    public static void test() {
        char[][] board = new char[][]{
                ".1...1...".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray()
        };

        System.out.println(isValidSudoku(board)); //false
    }

    public static void main(String[] args) {
        test();
    }
}

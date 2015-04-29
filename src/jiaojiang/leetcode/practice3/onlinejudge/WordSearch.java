package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/28/15 3:43 PM
 */
public class WordSearch {
    /*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
    horizontally or vertically neighboring. The same letter cell may not be used more than once.

    For example,
    Given board =

    [
      ["ABCE"],
      ["SFCS"],
      ["ADEE"]
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
     */
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, 0, visited, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean exist(char[][] board, String word, int w, boolean[][] visited, int i, int j) {
        if (w == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(w)) {
            return false;
        }

        visited[i][j] = true;

        if ( !(exist(board, word, w + 1, visited, i, j - 1) || exist(board, word, w + 1, visited, i - 1, j)
                || exist(board, word, w + 1, visited, i + 1, j) || exist(board, word, w + 1, visited, i, j + 1)) ) {
            visited[i][j] = false;
            return false;
        }

        //not correct if board is 1 X 1
//        if ( !((j > 0 && exist(board, word, w + 1, visited, i, j - 1))
//                || (i > 0 && exist(board, word, w + 1, visited, i - 1, j))
//                || (i < board.length - 1 && exist(board, word, w + 1, visited, i + 1, j))
//                || (j < board[0].length - 1 && exist(board, word, w + 1, visited, i, j + 1))) ) {
//            visited[i][j] = false;
//            return false;
//        }

        return true;
    }
}

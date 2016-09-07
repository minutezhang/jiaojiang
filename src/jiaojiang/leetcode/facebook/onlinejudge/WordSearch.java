package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class WordSearch {
    /*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
    horizontally or vertically neighboring. The same letter cell may not be used more than once.

    For example,
    Given board =

    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
     */
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, 0, hasVisited, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, int index, boolean[][] hasVisited, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || hasVisited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }

        hasVisited[i][j] = true;

        if (exist(board, word, index + 1, hasVisited, i - 1, j)
                || exist(board, word, index + 1, hasVisited, i + 1, j)
                || exist(board, word, index + 1, hasVisited, i, j - 1)
                || exist(board, word, index + 1, hasVisited, i, j + 1)) {
            return true;
        }

        hasVisited[i][j] = false;
        
        return false;
    }
}

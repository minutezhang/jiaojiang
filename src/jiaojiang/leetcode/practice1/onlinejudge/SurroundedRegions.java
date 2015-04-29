package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @since: May 16, 2013 9:43:47 PM
 */
public class SurroundedRegions {
    /*
    Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region .

    For example,

    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X
    */
    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        Queue<int[]> q = new LinkedList<int[]>();

        int m = board.length, n = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'I';
                q.add(new int[]{0, i});
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = 'I';
                q.add(new int[]{m - 1, i});
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'I';
                q.add(new int[] {i, 0});
            }

            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'I';
                q.add(new int[] {i, n - 1});
            }
        }

        while (!q.isEmpty()) {
            int[] i = q.remove();
            if (i[0] - 1 >= 0 && board[i[0] - 1][i[1]] == 'O') {
                q.add(new int[]{i[0] - 1, i[1]});
                board[i[0] - 1][i[1]] = 'I';
            }

            if (i[0] + 1 < m && board[i[0] + 1][i[1]] == 'O') {
                q.add(new int[]{i[0] + 1, i[1]});
                board[i[0] + 1][i[1]] = 'I';
            }

            if (i[1] - 1 >= 0 && board[i[0]][i[1] - 1] == 'O') {
                q.add(new int[]{i[0], i[1] - 1});
                board[i[0]][i[1] - 1] = 'I';
            }

            if (i[1] + 1 < n && board[i[0]][i[1] + 1] == 'O') {
                q.add(new int[]{i[0], i[1] + 1});
                board[i[0]][i[1] + 1] = 'I';
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'I') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /*
    "XXXXX",
    "XXXXX",
    "XXXXX",
    "XXXXX",
    "XOXXX"
    */
    public static void test() {
        char[][] board = new char[][]{
                "XXXXX".toCharArray(),
                "XOOOX".toCharArray(),
                "XXOOX".toCharArray(),
                "XXXOX".toCharArray(),
                "XOXXX".toCharArray()
        };

        solve(board);
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println();

        board = new char[][]{
                "OO".toCharArray(),
                "OO".toCharArray(),
        };

        solve(board);
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}

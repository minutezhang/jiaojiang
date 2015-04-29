package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: mizhang
 * @time: 4/24/15 5:01 PM
 */
public class NumberOfIslands {
    /*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
    and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
    are all surrounded by water.

    Example 1:

    11110
    11010
    11000
    00000
    Answer: 1

    Example 2:

    11000
    11000
    00100
    00011
    Answer: 3
     */
    public static int numIslands(char[][] grid) {
        int m = grid.length, n = m == 0 ? 0 : grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkAndSet(visited, grid, i, j, queue)) {
                    count++;
                    while (!queue.isEmpty()) {
                        int r = queue.remove(), c = queue.remove();
                        checkAndSet(visited, grid, r - 1, c, queue);
                        checkAndSet(visited, grid, r + 1, c, queue);
                        checkAndSet(visited, grid, r, c + 1, queue);
                        checkAndSet(visited, grid, r, c - 1, queue);
                    }
                }
            }
        }

        return count;
    }

    private static boolean checkAndSet(boolean[][] isVisited, char[][] grid, int i, int j, Queue<Integer> queue) {
        int m = grid.length, n = grid[0].length;
        if (i >= 0 && j >= 0 && i < m && j < n && !isVisited[i][j] && grid[i][j] == '1') {
            queue.add(i);
            queue.add(j);
            return isVisited[i][j] = true;
        }
        return false;
    }
}

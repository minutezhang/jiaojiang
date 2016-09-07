package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
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
        if (grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        boolean[][] hasVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (traverse(grid, i, j, hasVisited)) {
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    public static boolean traverse(char[][] grid, int i, int j, boolean[][] hasVisited) {
        boolean isIsland = isIsland(grid, i, j, hasVisited);
        if (isIsland) {
            hasVisited[i][j] = true;
            traverse(grid, i - 1, j, hasVisited);
            traverse(grid, i + 1, j, hasVisited);
            traverse(grid, i, j - 1, hasVisited);
            traverse(grid, i, j + 1, hasVisited);
        }
        return isIsland;
    }

    public static boolean isIsland(char[][] grid, int i, int j, boolean[][] hasVisited) {
        return  !(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || hasVisited[i][j] || grid[i][j] == '0');
    }
}

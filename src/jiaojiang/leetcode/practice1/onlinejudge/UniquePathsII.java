package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 30, 2013 12:06:46 AM
 */
public class UniquePathsII {
    /*
    Follow up for "Unique Paths":

    Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    For example,

    There is one obstacle in the middle of a 3x3 grid as illustrated below.

    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    The total number of unique paths is 2.

    Note: m and n will be at most 100.
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n) {

        if (m == obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1) {
            return obstacleGrid[m][n] == 0? 1 : 0;
        }

        if (m >= obstacleGrid.length || n >= obstacleGrid[0].length || obstacleGrid[m][n] == 1) {
            return 0;
        }

//        if (m == obstacleGrid.length - 1) {
//            for (int i = n; i < obstacleGrid[m].length; i++ ) {
//                if ( obstacleGrid[m][i] == 1) {
//                    return 0;
//                }
//            }
//            return 1;
//        }
//
//        if (n == obstacleGrid[0].length - 1) {
//            for (int i = m; i < obstacleGrid.length; i++) {
//                if (obstacleGrid[i][n] == 1) {
//                    return 0;
//                }
//            }
//            return 1;
//        }

        return uniquePathsWithObstacles(obstacleGrid, m + 1, n) + uniquePathsWithObstacles(obstacleGrid, m, n + 1);
    }

    public static int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 0 ? 1 : 0;

        for (int i = m - 2; i >= 0; i--) {
            paths[i][n - 1] = obstacleGrid[i][n - 1] == 1 ? 0 : paths[i + 1][n - 1];
        }

        for (int i = n - 2; i >=0; i--) {
            paths[m - 1][i] = obstacleGrid[m - 1][i] == 1 ? 0 : paths[m - 1][i + 1];
        }

        for (int i = m - 2; i >=0; i--) {
            for (int j = n - 2; j >=0; j--) {
                paths[i][j] = obstacleGrid[i][j] == 1 ? 0 : paths[i + 1][j] + paths[i][j + 1];
            }
        }

        return paths[0][0];
    }

    public static int[][] getBoard() {
        return new int[][]{{0,0,0}, {0, 1, 0}, {0, 0, 0}};
    }

    public static int[][] getBoard2() {
        return new int[][] {
                {0,0,0,0},
                {0,1,0,0},
                {0,0,0,0},
                {0,0,1,0},
                {0,0,0,0}
        };
    }


    public static void test() {
        System.out.println(uniquePathsWithObstacles(getBoard()));   //2
        System.out.println(uniquePathsWithObstaclesDP(getBoard()));  //2
        System.out.println(uniquePathsWithObstacles(getBoard2()));   //7
        System.out.println(uniquePathsWithObstaclesDP(getBoard2()));  //7
    }

    public static void main(String[] args) {
        test();
    }
}

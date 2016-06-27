package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Jun 1, 2016
 */
public class DungeonGame {
    /*
    The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon
    consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left
    room and must fight his way through the dungeon to rescue the princess.

    The knight has an initial health point represented by a positive integer. If at any point his health point drops
    to 0 or below, he dies immediately.

    Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
    other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

    In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward
    in each step.

    Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

    For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the
    optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

    -2(K) -3   	3
    -5 	  -10 	1
    10 	  30 	-5(P)

    Notes:

        The knight's health has no upper bound.
        Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room
        where the princess is imprisoned.

     */
    public static int calculateMinimumHP(int[][] dungeon) {
        return Math.max(1, 1 - calcMinCost(dungeon, 0, 0, 0, Integer.MAX_VALUE));
    }

    private static int calcMinCost(int[][] dungeon, int i, int j, int cost, int min) {
        int m = dungeon.length, n = dungeon[0].length;

        min = Math.min(cost + dungeon[i][j], min);
        cost += dungeon[i][j];

        if (i == m - 1 && j == n - 1) {
            return min;
        }

        if (i == m - 1) {
            return calcMinCost(dungeon, i, j + 1, cost, min);
        }

        if (j == n - 1) {
            return calcMinCost(dungeon, i + 1, j , cost, min);
        }

        return  Math.max(calcMinCost(dungeon, i + 1, j, cost, min),
                calcMinCost(dungeon, i, j + 1, cost, min));
    }

    public static int calculateMinimumHP2(int[][] dungeon) {
        return Math.max(1, 1 - calcMinCost2(dungeon, 0, 0));
    }

    public static int calcMinCost2(int[][] dungeon, int i, int j) {
        int m = dungeon.length, n = dungeon[0].length;

        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j];
        }

        if (i == m - 1) {
            return dungeon[i][j] + Math.min(0, calcMinCost2(dungeon, i, j + 1));
        }

        if (j == n - 1) {
            return dungeon[i][j] + Math.min(0, calcMinCost2(dungeon, i + 1, j));
        }

        return dungeon[i][j] + Math.min(0, Math.max(calcMinCost2(dungeon, i + 1, j), calcMinCost2(dungeon, i, j + 1)));
    }


    public static int calculateMinimumHPDp(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dungeon[i][n - 1] + Math.min(0, dp[i + 1][n - 1]);
        }

        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = dungeon[m - 1][j] + Math.min(0, dp[m - 1][j + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dungeon[i][j] + Math.min(0, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }

        return Math.max(1, 1 - dp[0][0]);
    }

    public static int calculateMinimumHP2Dp(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;

        int[] dp = new int[n];

        dp[n - 1] = dungeon[m - 1][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = dungeon[m - 1][j] + Math.min(0, dp[j + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = dungeon[i][n - 1] + Math.min(0, dp[n - 1]);
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dungeon[i][j] + Math.min(0, Math.max(dp[j], dp[j + 1]));
            }
        }

        return Math.max(1, 1 - dp[0]);
    }
}

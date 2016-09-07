package jiaojiang.leetcode.facebook.onlinejudge;

import utils.Utils;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class PaintHouseII {
    /*
    There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each
    house with a certain color is different. You have to paint all the houses such that no two adjacent houses
    have the same color.
    The cost of painting each house with a certain color is represented by a n x k cost matrix. For example,
    costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with
    color 2, and so on... Find the minimum cost to paint all houses.
    Note:
    All costs are positive integers.
    Follow up:
    Could you solve it in O(nk) runtime?
     */


    public static int minCostII(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int[] dp = new int[n];  // dp[i][j] is the total costs starting from house i, which painted with color j
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = costs[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            leftMin[0] = rightMin[n - 1] = Integer.MAX_VALUE;
            for (int j = 1; j < n; j++) {
                leftMin[j] = Math.min(leftMin[j - 1], dp[j - 1]);
                rightMin[n - j - 1] = Math.min(rightMin[n - j], dp[n - j]);
            }
            for (int j = 0; j < n; j++) {
                dp[j] = costs[i][j] + Math.min(leftMin[j], rightMin[j]);
            }
        }

        int totalCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            totalCost = Math.min(totalCost, dp[i]);
        }

        return totalCost;
    }

    public static int minCostIIDP(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];  // dp[i][j] is the total costs starting from house i, which painted with color j

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = costs[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            leftMin[0] = rightMin[n - 1] = Integer.MAX_VALUE;
            for (int j = 1; j < n; j++) {
                leftMin[j] = Math.min(leftMin[j - 1], dp[i + 1][j - 1]);
                rightMin[n - j - 1] = Math.min(rightMin[n - j], dp[i + 1][n - j]);
            }
            for (int j = 0; j < n; j++) {
                dp[i][j] = costs[i][j] + Math.min(leftMin[j], rightMin[j]);
            }
        }

        int totalCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            totalCost = Math.min(totalCost, dp[0][i]);
        }

        return totalCost;
    }

    public static int minCostIIRecursive(int[][] costs) {
        return minCostII(0, -1, 0, costs);
    }

    private static int minCostII(int houseIndex, int preColorIndex, int preCost, int[][] costs) {
        if (houseIndex == costs.length) {
            return preCost;
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            if (i != preColorIndex) {
                minCost = Math.min(minCost, minCostII(houseIndex + 1, i, preCost + costs[houseIndex][i], costs));
            }
        }

        return minCost; 
    }
}

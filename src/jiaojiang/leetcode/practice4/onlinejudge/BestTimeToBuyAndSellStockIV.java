package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Jun 7, 2016
 */
public class BestTimeToBuyAndSellStockIV {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most k transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */

    // Recursive method 1
    public static int maxProfit(int k, int[] prices) {
        return k == 0 ? 0: maxProfit(k, prices, 0, prices.length - 1);
    }

    private static int maxProfit(int k, int[] prices, int start, int end) {
        if (end == start) {
            return 0;
        }

        if (k == 1) {
            return maxProfitOne(prices, start, end);
        }

        int maxProfit = 0;
        for (int i = start + 1; i <= end; i++) {
            maxProfit = Math.max(maxProfit, maxProfitOne(prices, start, i) + maxProfit(k - 1, prices, i + 1, end));
        }

        return maxProfit;
    }

    private static int maxProfitOne(int[] prices, int start, int end) {
        int currentMin = Integer.MAX_VALUE, profit = 0;
        for (int i = start; i <= end; i++) {
            profit = Math.max(profit, prices[i] - currentMin);
            if (prices[i] < currentMin) {
                currentMin = prices[i];
            }
        }

        return profit;
    }


    // dynamic programming method 2
    public static int maxProfitDp(int k, int[] prices) {
        if (prices.length <= 1 || k == 0) {
            return 0;
        }

        if ((prices.length >> 1) <= k) {
            return maxProfitUnlimited(prices);
        }

        int[][][] dp = new int[2][prices.length][prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                dp[0][i][j] = dp[1][i][j] = maxProfitOne(prices, i, j);
            }
        }

        for (int l = 1; l < k; l++) {
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int max = 0;
                    for (int m = i + 1; m < j; m++) {
                        dp[1][i][j] = max = Math.max(dp[0][i][j], Math.max(max, dp[0][i][m] + dp[1][m + 1][j]));
                    }
                }
            }
        }

        return dp[1][0][prices.length - 1];
    }

    // find the max profit with unlimited transactions
    private static int maxProfitUnlimited(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }


    // other method 3
    public static int maxProfit2Dp(int k, int[] prices) {
        List<Interval> profits = new ArrayList<Interval>();

        for (int i = 0, j; i < prices.length; i = j) {
            for (j = i + 1; j < prices.length && prices[j] >= prices[j - 1]; j++);
            if (prices[j - 1] > prices[i]) {
                profits.add(new Interval(prices[i], prices[j - 1]));
            }
        }

        while (profits.size() > k) {
            int mergeLoss, minMergeLossIndex = -1, minMergeLoss = Integer.MAX_VALUE, profit, minProfitIndex = 0, minProfit = profits.get(0).close - profits.get(0).open;
            for (int i = 1, l = profits.size(); i < l; i++) {
                Interval preInterval = profits.get(i - 1), interval = profits.get(i);
                if (interval.close > preInterval.close && (mergeLoss = preInterval.close - interval.open) < minMergeLoss) {
                    minMergeLossIndex = i;
                    minMergeLoss = mergeLoss;
                }

                if ((profit = interval.close - interval.open) < minProfit) {
                    minProfit = profit;
                    minProfitIndex = i;
                }
            }

            // we can merge and the loss of merge is less than the loss of removal
            if (minMergeLossIndex >= 0 && minMergeLoss < minProfit) {
                profits.get(minMergeLossIndex - 1).close = profits.get(minMergeLossIndex).close;
                profits.remove(minMergeLossIndex);
            } else { //otherwise, remove the minimal
                profits.remove(minProfitIndex);
            }
        }

        int totalProfit = 0;
        for (Interval profit : profits) {
            totalProfit += profit.close - profit.open;
        }

        return totalProfit;
    }

    private static class Interval {
        int open;
        int close;

        private Interval(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
}

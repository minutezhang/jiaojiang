package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/29/15 10:16 PM
 */
public class BestTimeToBuyAndSellStockIII {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most two transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];

        int leftBuyMin = prices[0], rightSellMax = prices[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            leftProfit[i] = Math.max(prices[i] - leftBuyMin, leftProfit[i - 1]);
            leftBuyMin = Math.min(leftBuyMin, prices[i]);

            rightProfit[prices.length - i - 1] = Math.max(rightSellMax - prices[prices.length - i - 1], rightProfit[prices.length - i]);
            rightSellMax = Math.max(rightSellMax, prices[prices.length - i - 1]);
        }

        //one transaction
        int profit = Math.max(rightProfit[0], leftProfit[prices.length - 1]);
        for (int i = 0; i < prices.length - 1; i++) {
            profit = Math.max(profit, leftProfit[i] + rightProfit[i + 1]);
        }

        return profit;
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/29/15 10:07 PM
 */
public class BestTimeToBuyAndSellStockII {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one
    and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same
    time (ie, you must sell the stock before you buy again).
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit += Math.max(0, prices[i + 1] - prices[i]);
        }

        return profit;
    }
}

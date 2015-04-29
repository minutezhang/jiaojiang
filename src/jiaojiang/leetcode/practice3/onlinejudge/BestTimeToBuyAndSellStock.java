package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/29/15 9:41 PM
 */
public class BestTimeToBuyAndSellStock {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
     an algorithm to find the maximum profit.
     */
    public static int maxProfit(int[] prices) {
        int profit = 0, minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}

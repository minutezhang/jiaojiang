package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 25, 2013 10:10:59 PM
 */
public class BestTimeToBuyAndSellStockII {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    (ie, buy one and sell one share of the stock multiple times). However, you may not engage in
    multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */

    //the best solution is consider the difference
    //e.g., for sequence 3,2,6,5,0,3, the difference is -1, 4, -1, -5, 3. Assume the difference is d[0...n-1], then
    //if you buy stock on ith day and sell on jth day, the profit is d[i] + d[i + 1] + ... + d[j]
    // so problem I become finding the consecutive sequence with max sum. Problem I can be done in one scan
    //problem II become finding the sum of all the positive difference
    public static int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }

    public static void test() {
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));       //7
        System.out.println(maxProfit(new int[]{1,2,4}));       //3
    }

    public static void main(String[] args) {
        test();
    }
}

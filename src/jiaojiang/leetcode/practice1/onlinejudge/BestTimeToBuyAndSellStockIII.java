package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 25, 2013 10:48:21 PM
 */
public class BestTimeToBuyAndSellStockIII {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most two transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] leftProfit = new int[prices.length], rightProfit = new int[prices.length];

        int low = prices[0], high = prices[prices.length - 1], maxProfit = 0;

        for (int j = prices.length - 2; j >=0; j--) {
            high = Math.max(high, prices[j]);
            rightProfit[j] = Math.max(high - prices[j], rightProfit[j + 1]);
        }

        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            leftProfit[i] = Math.max(prices[i] - low, leftProfit[i - 1]);
        }

        for (int i = 1; i < prices.length - 2; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i + 1]);
        }

        return Math.max(maxProfit, Math.max(leftProfit[leftProfit.length - 1], rightProfit[0]));
    }

    public static void test() {
//        System.out.printTestln(maxProfit(new int[]{2,1,4,5,2,9,7})); //  11
//        System.out.printTestln(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0,9})); // 17
        System.out.println(maxProfit(new int[]{2,1,2,1,0,0,1})); // 2
    }

    public static void main(String[] args) {
        test();
    }
}

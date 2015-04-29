package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 25, 2013 8:49:20 PM
 */
public class BestTimeToBuyAndSellStock {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] max = new int[prices.length];
        max[prices.length - 1] = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], prices[i]);
        }

        int min = prices[0], profit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, max[i - 1] - min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int max = 0, sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i - 1];
            max = Math.max(max, sum);
            sum = Math.max(0, sum);
        }

        return max;
    }

    public static int maxProfit3(int[] prices) {
        if (prices.length == 0){
            return 0;
        }

        int low = prices[0], profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            low = Math.min(prices[i], low);
            profit = Math.max(profit, prices[i] - low);
        }

        return profit;
    }

    public static void test() {
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));//4
        System.out.println(maxProfit2(new int[]{3,2,6,5,0,3}));//4
        System.out.println(maxProfit3(new int[]{3,2,6,5,0,3}));//4
    }

    public static void main(String[] args) {
        test();
    }
}

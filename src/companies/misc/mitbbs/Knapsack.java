package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Oct 6, 2013 12:11:37 AM
 */
/*
Given n items with weight w_i and value_i, find k from n such that all the weight is no greater than given weights with maximal
value
 */
public class Knapsack {
    public static int maxValue(int[] weights, int[] values, int maxWeight) {
        int[] currentValues = new int[maxWeight + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < currentValues.length; j++) {
                if (j + weights[i] <= maxWeight) {
                    currentValues[j + weights[i]] = Math.max(currentValues[j + weights[i]], currentValues[j] + values[i]);
                }
            }
        }

        int maxValue = 0;
        for (int v : currentValues) {
            if (maxValue < v) {
                maxValue = v;
            }
        }

        return maxValue;
    }

    public static void test() {
        Utils.printTestln(maxValue(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 9, 13, 15}, 5), 16);
        Utils.printTestln(maxValue(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 9, 13, 15}, 7), 22);
    }

    public static void main(String[] args) {
        test();
    }
}
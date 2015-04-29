package companies.facebook.glassdoor;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 7, 2014 9:55:21 PM
 */
public class MaxCostJobs {
    /*
     Given a set of n jobs with [start time, end time, cost] find a subset so that no 2 jobs overlap and the cost is maximum
     */
    public static int maxCost(int[] start, int[] end, int[] cost) {
        return maxCost(start, end, cost, 0);
    }

    private static int maxCost(int[] start, int[] end, int[] cost, int index) {
        if (index == start.length)  {
            return 0;
        }

        int nextIdx;
        for (nextIdx = index + 1; nextIdx < start.length && end[index] > start[nextIdx]; nextIdx++);
        return Math.max(cost[index] + maxCost(start, end, cost, nextIdx), maxCost(start, end, cost, index + 1));
    }

    private static void test() {
        Utils.printTestln(maxCost(new int[]{1, 2, 5, 8, 15}, new int[]{3, 6, 9, 10, 18}, new int[]{4, 6, 2, 7, 5}), 18);
    }

    public static void main(String[] args) {
        test();
    }

}

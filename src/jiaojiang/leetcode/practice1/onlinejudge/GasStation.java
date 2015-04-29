package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Oct 25, 2013 11:01:14 AM
 */
public class GasStation {
    /*
     There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next
    station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Note:
    The solution is guaranteed to be unique.
     */

    //Solution: calculate the diff first and find the max sum subarray.  Meantime, keep the max gap (minSum) between the gas and
    //cost, and compare them at the end. By the way, minSum only gets updated when the subarry is sum to a negative
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, minSum = 0, partialSum = 0, index = 0;

        for (int i = 0; i < gas.length; i++) {
            partialSum += gas[i] - cost[i];

            if (partialSum < 0) {
                sum += partialSum;
                minSum = Math.min(sum, minSum);
                partialSum = 0;
                index = i + 1;
            }
        }

        if (index < gas.length && partialSum + minSum >= 0) {
            return index;
        }

        return -1;
    }

    public static void test() {
        Utils.printTestln(canCompleteCircuit(new int[]{4}, new int[]{5}), -1);
        Utils.printTestln(canCompleteCircuit(new int[]{5}, new int[]{4}), 0);
        Utils.printTestln(canCompleteCircuit(new int[]{1, 2}, new int[]{2, 1}), 1);
        Utils.printTestln(canCompleteCircuit(new int[]{2, 3, 1}, new int[]{3, 1, 2}), 1);
        Utils.printTestln(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}), 3);
        Utils.printTestln(canCompleteCircuit(new int[]{6,0,1,3,2}, new int[]{4,5,2,5,5}), -1);
    }

    public static void main(String[] args) {
        test();
    }
}
package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Arrays;

/**
 * @author: zhang
 * @since: Jun 2, 2013 7:54:31 PM
 */
public class ThreeSumClosest {
    /*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public static int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE, closeSum = target;

        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                if (num[start] + num[end]  + num[i] == target) {
                    return target;
                }

                int sum = num[start] + num[end] + num[i];
                int diff = sum - target;
                if (Math.abs(diff) < min) {
                    min = Math.abs(diff);
                    closeSum = sum;
                }

                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return closeSum;
    }

    public static void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static void main(String[] args) {
        test();
    }
}

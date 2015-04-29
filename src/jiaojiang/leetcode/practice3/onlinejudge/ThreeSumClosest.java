package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Arrays;

/**
 * @author: mizhang
 * @time: 3/17/15 9:00 AM
 */
public class ThreeSumClosest {
    /*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int eps = Integer.MAX_VALUE, closest = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1, k = num.length - 1; j < k;) {
                if (num[i] + num[j] + num[k] == target) {
                    return target;
                }

                if(Math.abs(num[i] + num[j] + num[k] - target) < eps) {
                    closest = num[i] + num[j] + num[k];
                    eps = Math.abs(num[i] + num[j] + num[k] - target);
                }

                if (num[i] + num[j] + num[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closest;
    }
}

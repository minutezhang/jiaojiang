package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/16/15 11:28 PM
 */
public class ThreeSum {
    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
        For example, given array S = {-1 0 1 2 -1 -4},

        A solution set is:
        (-1, 0, 1)
        (-1, -1, 2)
     */
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                for (int j = i + 1, k = num.length - 1; j < k;) {
                    if (j > i + 1 && num[j] == num[j - 1]) {
                        j++;
                        continue;
                    }

                    if (k < num.length - 1 && num[k] == num[k + 1]) {
                        k--;
                        continue;
                    }

                    if (num[j] + num[k] == -num[i]) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        ret.add(list);
                        j++;
                        k--;
                    } else if (num[j] + num[k] < -num[i]) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return ret;
    }
}

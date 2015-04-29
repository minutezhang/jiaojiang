package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: May 13, 2013 10:25:01 PM
 */
public class CombinationSumII {
    /*
    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    Each number in C may only be used once in the combination.

    Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, ? , ak) must be in non-descending order. (ie, a1 ? a2 ? ? ? ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 10,1,2,7,6,1,5 and target 8,
    A solution set is:
    [1, 7]
    [1, 2, 5]
    [2, 6]
    [1, 1, 6]
     */
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return combinationSum2(num, num.length - 1, target);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int index, int target) {
        ArrayList<ArrayList<Integer>>  ret = new ArrayList<ArrayList<Integer>>();

        if (target == 0) {
            ArrayList<Integer> comb = new ArrayList<Integer>();
            ret.add(comb);
            return ret;
        }

        if (index < 0 || target < 0) {
            return ret;
        }

        int count = 0;
        while (index >= count && num[index - count] == num[index]) {
            count++;
        }

        for (int i = 0; i <= count; i++) {
            for (ArrayList<Integer> comb : combinationSum2(num, index - count, target - num[index] * i)) {
                for (int j = 0; j < i; j++) {
                    comb.add(num[index]);
                }
                ret.add(comb);
            }
        }

        return ret;
    }

    public static void test() {
        for (ArrayList<Integer> comb : combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)) {
            for (int i : comb) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}

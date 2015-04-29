package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: May 13, 2013 5:18:27 PM
 */
public class CombinationSum {
    /*
    Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.

    Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, ? , ak) must be in non-descending order. (ie, a1 ? a2 ? ? ? ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 2,3,6,7 and target 7,
    A solution set is:
    [7]
    [2, 2, 3]
     */

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates,  candidates.length - 1, target);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int index, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (target == 0) {
            ArrayList<Integer> comb = new ArrayList<Integer>();
            ret.add(comb);
            return ret;
        }

        if (index < 0 || target < 0) {
            return ret;
        }

        for (int i = 0; candidates[index] * i <= target; i++) {
            for (ArrayList<Integer> comb : combinationSum(candidates, index - 1, target - candidates[index] * i)) {
                for (int j = 0 ; j < i; j++) {
                    comb.add(candidates[index]);
                }
                ret.add(comb);
            }
        }

        return ret;
    }

    public static void test() {
        for (ArrayList<Integer> integers : combinationSum(new int[] {2, 3, 6, 7}, 7)) {
            for (int i : integers) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @date: Apr 28, 2015 10:15:15 AM
 */
public class CombinationSum {
    /*
    Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
    numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.

    Note:

        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
        The solution set must not contain duplicate combinations.

    For example, given candidate set 2,3,6,7 and target 7,
    A solution set is:
    [7]
    [2, 2, 3]
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        combinationSum(candidates, target, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    private static void combinationSum(int[] candidates, int target, int level, List<Integer> sum, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(sum));
        } else if (target > 0) {
            for (int i = level; i < candidates.length; i++) {
                sum.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, sum, ret);
                sum.remove(sum.size() - 1);
            }
        }
    }
}

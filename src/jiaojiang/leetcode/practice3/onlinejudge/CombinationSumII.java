package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @date: Apr 28, 2015 2:32:59 PM
 */
public class CombinationSumII {
    /*
     Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
     candidate numbers sums to T.

    Each number in C may only be used once in the combination.

    Note:

        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
        The solution set must not contain duplicate combinations.

    For example, given candidate set 10,1,2,7,6,1,5 and target 8,
    A solution set is:
    [1, 7]
    [1, 2, 5]
    [2, 6]
    [1, 1, 6]
     */
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        combinationSum2(num, target, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    private static void combinationSum2(int[] num, int target, int level, List<Integer> container, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(container));
        } else if (target > 0) {
            for (int i = level, j, k; i < num.length; i = j) {
                for (j = i + 1; j < num.length && num[j] == num[i]; j++);
                for (k = 0; k < j - i && target - (k + 1) * num[i] >= 0; k++) {
                    container.add(num[i]);
                    combinationSum2(num, target - (k + 1) * num[i], j, container, ret);
                }
                for (; k > 0; k--, container.remove(container.size() - 1));
            }
        }
    }
}

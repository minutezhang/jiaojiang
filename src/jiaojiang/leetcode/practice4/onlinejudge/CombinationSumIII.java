package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Jul 27, 2016
 */
public class CombinationSumIII {
    /**
     *
    Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
     used and each combination should be a unique set of numbers.

    Example 1:

    Input: k = 3, n = 7

    Output:

    [[1,2,4]]


    Example 2:

    Input: k = 3, n = 9

    Output:

    [[1,2,6], [1,3,5], [2,3,4]]
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, 0);
    }

    public static List<List<Integer>> combinationSum3(int k, int n, int prev) {
        if (k == 0) {
            if(n == 0) {
                List<List<Integer>> ret = new ArrayList<List<Integer>>();
                ret.add(new ArrayList<Integer>());
                return ret;
            }
            return null;
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = prev + 1; i <= Math.min(9, n); i++) {
            List<List<Integer>> tmpList = combinationSum3(k - 1, n - i, i);
            if (tmpList != null) {
                for (List<Integer> list : tmpList) {
                    list.add(0, i);
                }
                ret.addAll(tmpList);
            }
        }

        return ret;
    }
}

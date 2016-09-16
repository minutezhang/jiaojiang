package jiaojiang.leetcode.uber.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 13, 2016
 */
public class FactorCombinations {
    /*
    Numbers can be regarded as product of its factors. For example,

    8 = 2 x 2 x 2;
      = 2 x 4.

    Write a function that takes an integer n and return all possible combinations of its factors.
    Note:
        Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
        You may assume that n is always positive.
        Factors should be greater than 1 and less than n.

    Examples:
    input: 1
    output:

    []

    input: 37
    output:

    []

    input: 12
    output:

    [
      [2, 6],
      [2, 2, 3],
      [3, 4]
    ]

    input: 32
    output:

    [
      [2, 16],
      [2, 2, 8],
      [2, 2, 2, 4],
      [2, 2, 2, 2, 2],
      [2, 4, 4],
      [4, 8]
    ]
     */
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        getFactors(n, ret, new ArrayList<Integer>());
        return ret;
    }

    private static void getFactors(int n, List<List<Integer>> ret, List<Integer> factors) {
        int preFactor = factors.isEmpty() ? 2 : factors.get(factors.size() - 1);
        if (preFactor > n) {
            return;
        }

        if (!factors.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>(factors);
            list.add(n);
            ret.add(list);
        }

        for (int i = preFactor; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                getFactors(n / i, ret, factors);
                factors.remove(factors.size() - 1);
            }
        }
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/5/15 10:59 PM
 */
public class Combination {
    /*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    For example,
    If n = 4 and k = 2, a solution is:

    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n - k + 1; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            ret.add(list);
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 0, s = ret.size(); j < s; j++) {
                List<Integer> seed = ret.get(j);
                for (int l = seed.get(seed.size() - 1) + 1; l < n - k + i; l++) {
                    List<Integer> list = new ArrayList<Integer>(seed);
                    list.add(l);
                    ret.add(list);
                }
                seed.add(n - k + i);
            }
        }

        return ret;
    }
}

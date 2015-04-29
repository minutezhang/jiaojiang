package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/3/15 9:51 PM
 */
public class Subsets {
    /*
    Given a set of distinct integers, S, return all possible subsets.

    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
     */
    public static List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> emptySet = new ArrayList<Integer>();
        ret.add(emptySet);

        for (int i : S) {
            for (int j = 0, size = ret.size(); j < size; j++) {
                List<Integer> set = new ArrayList<Integer>(ret.get(j));
                set.add(i);
                ret.add(set);
            }
        }

        return ret;
    }
}

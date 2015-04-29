package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhang
 * @date: Apr 26, 2015 10:13:16 PM
 */
public class SubsetsII {
    /*
    Given a collection of integers that might contain duplicates, S, return all possible subsets.

    Note:

        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.

    For example,
    If S = [1,2,2], a solution is:

    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
     */
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        Arrays.sort(num);

        for (int i = 0, lastIndex = 0; i < num.length; i++) {
            int startIndex = i > 0 && num[i - 1] == num[i] ? lastIndex : 0;
            lastIndex = ret.size();
            for (int j = startIndex; j < lastIndex; j++) {
                List<Integer> list = new ArrayList<Integer>(ret.get(j));
                list.add(num[i]);
                ret.add(list);
            }
        }
        return ret;
    }
}

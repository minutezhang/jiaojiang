package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class Subsets {
    /*
    Given a set of distinct integers, nums, return all possible subsets.

    Note: The solution set must not contain duplicate subsets.

    For example,
    If nums = [1,2,3], a solution is:

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
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        Arrays.sort(nums);

        for (int num : nums) {
            for (int i = 0, s = ret.size(); i < s; i++) {
                List<Integer> tmpList = new ArrayList<Integer>(ret.get(i));
                tmpList.add(num);
                ret.add(tmpList);
            }
        }

        return ret;
    }
}

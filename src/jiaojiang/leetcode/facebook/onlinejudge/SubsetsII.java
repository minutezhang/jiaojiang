package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class SubsetsII {
    /*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets.

    Note: The solution set must not contain duplicate subsets.

    For example,
    If nums = [1,2,2], a solution is:

    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());

        int depth = 0;
        for (int i = 0; i < nums.length; i++) {
            depth = i > 0 && nums[i] == nums[i - 1] ? depth + 1 : 0;
            for (int j = 0, s = ret.size(); j < s; j++) {
                List<Integer> list = ret.get(j);
                if (depth == 0
                        ||list.size() >= depth && list.get(list.size() - depth) == nums[i]) {
                    List<Integer> tmpList = new ArrayList<Integer>(list);
                    tmpList.add(nums[i]);
                    ret.add(tmpList);
                }
            }
        }

        return ret;
    }
}

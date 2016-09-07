package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 *
 * Created on Aug 26, 2016
 */
public class TwoSum {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

    UPDATE (2016/2/13):
    The return format had been changed to zero-based indices. Please read the above updated description carefully.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(target - nums[i])) {
                return new int[]{indices.get(target - nums[i]), i};
            }
            indices.put(nums[i], i);
        }

        return null;
    }
}

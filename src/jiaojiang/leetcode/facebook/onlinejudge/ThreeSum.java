package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Aug 26, 2016
 */
public class ThreeSum {
    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique
    triplets in the array which gives the sum of zero.

    Note: The solution set must not contain duplicate triplets.

    For example, given array S = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length;) {
            int target = -nums[i], start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    ret.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    for(start++; start < end && nums[start - 1] == nums[start]; start++);
                    for(end--; start < end && nums[end] == nums[end + 1]; end--);
                } else if (nums[start] + nums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
            for(i++; i < nums.length && nums[i] == nums[i - 1]; i++);
        }

        return ret;
    }
}

package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.TreeSet;

/**
 * @author zhang
 *
 * Created on Mar 10, 2016
 */
public class ContainsDuplicateIII {
    /*
    Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
    difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();

        for (int i = 0; i < nums.length; i++) {
            Long num;
            if ((num = set.ceiling((long)nums[i])) != null && num - nums[i] <= t) {
                return true;
            }

            if ((num = set.floor((long)nums[i])) != null && nums[i] - num <= t) {
                return true;
            }

            set.add((long)nums[i]);

            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }

        return false;
    }
}

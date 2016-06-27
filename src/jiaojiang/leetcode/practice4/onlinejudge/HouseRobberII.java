package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Jun 23, 2016
 */
public class HouseRobberII {
    /*
    Note: This is an extension of House Robber.

    After robbing those houses on that street, the thief has found himself a new place for his thievery so that he
    will not get too much attention. This time, all houses at this place are arranged in a circle. That means the
    first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as
    for those in the previous street.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
    of money you can rob tonight without alerting the police.
     */
    public static int rob(int[] nums) {
        return nums.length == 1 ? nums[0] : Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private static int rob(int[] nums, int start, int end) {
        return start >= end ? 0 : Math.max(rob(nums, start + 1, end), nums[start] + rob(nums, start + 2, end));
    }

    public static int robDp(int[] nums) {
        return nums.length == 1 ? nums[0] : Math.max(robDp(nums, 0, nums.length - 2), robDp(nums, 1, nums.length - 1));
    }

    private static int robDp(int[] nums, int start, int end) {
        int[] m = new int[2];
        for (int i = end; i >= start; i--) {
            m[i&1] = Math.max(nums[i] + m[i & 1], m[(i + 1) & 1]);
        }
        return m[start & 1];
    }
}

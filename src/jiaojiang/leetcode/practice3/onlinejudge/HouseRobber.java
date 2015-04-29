package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 4/24/15 3:03 PM
 */
public class HouseRobber {
    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
    stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
    connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
    of money you can rob tonight without alerting the police.
     */

    private static int rob(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        return Math.max(nums[start] + rob(nums, start + 2), rob(nums, start + 1));
    }

    public static int rob(int[] nums) {
        return rob(nums, 0);
    }

    public static int robDP(int[] nums) {
        int[] rob = new int[2];

        for (int i = nums.length - 1; i >= 0; i--) {
            rob[i & 1] = Math.max(nums[i] + rob[(i + 2) & 1], rob[(i + 1) & 1]);
        }

        return rob[0];
    }
}

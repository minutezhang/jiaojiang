package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
 */
public class MinimumSizeSubarraySum {
    /*
     Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which
     the sum ³ s. If there isn't one, return 0 instead.

    For example, given the array [2,3,1,2,4,3] and s = 7,
    the subarray [4,3] has the minimal length under the problem constraint.
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0, minLength = Integer.MAX_VALUE;
        for (int start = 0, end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum >= s) {
                for (; sum - nums[start] >= s; sum -= nums[start], start++);
                minLength = Math.min(end - start + 1, minLength);
            }
        }
        return sum < s ? 0 : minLength;
    }
}

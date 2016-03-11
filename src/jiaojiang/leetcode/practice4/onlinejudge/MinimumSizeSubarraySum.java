package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 9, 2016
 */
public class MinimumSizeSubarraySum {
    /*
     Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which
     the sum ³ s. If there isn't one, return 0 instead.

    For example, given the array [2,3,1,2,4,3] and s = 7,
    the subarray [4,3] has the minimal length under the problem constraint.

    click to show more practice.
    More practice:

    If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
    */
    
    public static int minSubArrayLen(int s, int[] nums) {
        int length = 0;
        for (int sum = 0, i = 0, j = 0; i < nums.length && j < nums.length; sum -= nums[i], i++) {
            for (; sum < s && j < nums.length; sum += nums[j], j++);
            for (; sum - nums[i] >= s & i < j; sum -= nums[i], i++);
            if (sum >= s && (j - i < length || length == 0)) {
                length = j - i;
            }
        }
        return length;
    }
}

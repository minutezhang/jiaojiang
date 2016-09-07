package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 *
 * Created on Sep 5, 2016
 */
public class MaximumSizeSubarraySumEqualsK {
    /*
    Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one,
    return 0 instead.
    Example 1:
    Given nums = [1, -1, 5, -2, 3], k = 3,
    return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
    Example 2:
    Given nums = [-2, -1, 2, 1], k = 1,
    return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
    Follow Up:
    Can you do it in O(n) time?
     */
    public static int maxSubArrayLen(int[] nums, int k) {
        //1, -1, 5, -2, 3}, 3
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        indices.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!indices.containsKey(sum)) {
                indices.put(sum, i);
            }
        }

        int maxLength = indices.containsKey(sum - k) ? nums.length - indices.get(sum - k) - 1: 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum -= nums[i];
            if (indices.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - indices.get(sum - k) - 1);
            }
        }

        return maxLength;
    }
}

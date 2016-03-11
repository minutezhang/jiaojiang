package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *         <p/>
 *         Created on Mar 3, 2016
 */
public class RangeSumQueryMutable {
    /*
    Given an integer array nums, find the sum of the elements between indices i and j (i ² j), inclusive.
    The update(i, val) function modifies nums by updating the element at index i to val.

    Example:

    Given nums = [1, 3, 5]

    sumRange(0, 2) -> 9
    update(1, 2)
    sumRange(0, 2) -> 8

    Note:

        The array is only modifiable by the update function.
        You may assume the number of calls to update and sumRange function is distributed evenly.
     */

    private int[] sum;

    public RangeSumQueryMutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] =  sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        int diff = val - sum[i + 1] + sum[i];
        for (int ii = i + 1; ii < sum.length; ii++) {
            sum[ii] += diff;
        }

    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 2, 2016
 */
public class RangeSumQueryImmutable {
    /*
    Given an integer array nums, find the sum of the elements between indices i and j (i ² j), inclusive.

    Example:

    Given nums = [-2, 0, 3, -5, 2, -1]

    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3

    Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.
     */

    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
    // Your RangeSumQueryImmutable object will be instantiated and called as such:
    // RangeSumQueryImmutable numArray = new RangeSumQueryImmutable(nums);
    // numArray.sumRange(0, 1);
    // numArray.sumRange(1, 2);
}

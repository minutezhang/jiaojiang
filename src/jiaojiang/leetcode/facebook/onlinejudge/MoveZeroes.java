package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class MoveZeroes {
    /*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
    the non-zero elements.

    For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

    Note:

        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.
     */
    public static void moveZeroes(int[] nums) {
        int writeIndex, readIndex;
        for (writeIndex = 0, readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        for(; writeIndex < nums.length; writeIndex++) {
            nums[writeIndex] = 0;
        }
    }
}

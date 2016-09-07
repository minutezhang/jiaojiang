package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 29, 2016
 */
public class RemoveDuplicatesFromSortedArray {
    /*
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
    length.

    Do not allocate extra space for another array, you must do this in place with constant memory.

    For example,
    Given input array nums = [1,1,2],

    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't
    matter what you leave beyond the new length.
     */
    public static int removeDuplicates(int[] nums) {
        int writeIndex = 1, readIndex = 1;
        for(; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}

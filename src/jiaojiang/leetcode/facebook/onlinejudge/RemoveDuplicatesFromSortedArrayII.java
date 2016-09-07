package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class RemoveDuplicatesFromSortedArrayII {
    /*
    Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?

    For example,
    Given sorted array nums = [1,1,1,2,2,3],

    Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't
    matter what you leave beyond the new length.
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int writeIdx, readIdx, count;
        for (writeIdx = 1, readIdx = 1, count = 1; readIdx < nums.length; readIdx++) {
            count = nums[readIdx] == nums[readIdx - 1] ? count + 1 : 1;
            
            if (count <= 2) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            }
        }

        return writeIdx;
    }
}

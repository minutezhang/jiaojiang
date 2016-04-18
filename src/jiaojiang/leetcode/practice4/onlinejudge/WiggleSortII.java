package jiaojiang.leetcode.practice4.onlinejudge;

import utils.Utils;

import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Mar 28, 2016
 */
public class WiggleSortII {
    /*
     Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    Example:
    (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
    (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

    Note:
    You may assume all input has valid answer.

    Follow Up:
    Can you do it in O(n) time and/or in-place with O(1) extra space?
     */
    public static void wiggleSort(int[] nums) {
        int[] tmpNums = new int[nums.length];

        System.arraycopy(nums, 0, tmpNums, 0, nums.length);

        Arrays.sort(tmpNums);

        for (int i = 0, j = ((nums.length + 1) >> 1) - 1, k = nums.length - 1; i < nums.length; i++) {
            nums[i] = (i & 1) == 1 ? tmpNums[k--] : tmpNums[j--];
        }
    }

    public static boolean isWiggle(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if ((i & 1) == 1 && (nums[i] <= nums[i - 1]|| nums[i] <= nums[i + 1])) {
                return false;
            }

            if ((i & 0) == 1 && (nums[i] >= nums[i - 1]|| nums[i] <= nums[i + 1])) {
                return false;
            }
        }

        return true;
    }

    //TODO: O(n) and in place method
    public static void wiggleSort2(int[] nums) {

    }
}

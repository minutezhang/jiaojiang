package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 29, 2016
 */
public class SortColors {
    /*
     Given an array with n objects colored red, white or blue, sort them so that objects of the same color are
     adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.
     */
    public static void sortColors(int[] nums) {
        for(int leftIdx = 0, rightIdx = nums.length - 1, idx = 0; idx <= rightIdx;) {
            switch(nums[idx]) {
                case 0 :
                    swap(nums, leftIdx, idx);
                    leftIdx++;
                    idx++;
                    break;
                case 1 :
                    idx++;
                    break;
                case 2 :
                    swap(nums, rightIdx, idx);
                    rightIdx--;
                    break;
            }

        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}

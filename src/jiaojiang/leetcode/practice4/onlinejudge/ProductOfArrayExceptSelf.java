package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class ProductOfArrayExceptSelf {
    /*
     Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product
     of all the elements of nums except nums[i].

    Solve it without division and in O(n).

    For example, given [1,2,3,4], return [24,12,8,6].

    Follow up:
    Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the
    purpose of space complexity analysis.)
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];
        leftProd[0] = 1;
        rightProd[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftProd[i] = leftProd[i - 1] * nums[i - 1];
            rightProd[nums.length - 1 - i] = rightProd[nums.length - i] * nums[nums.length - i];
        }

        for (int i = 0; i < nums.length; i++) {
            ret[i] = leftProd[i] * rightProd[i];
        }

        return ret;
    }
}

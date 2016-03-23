package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 20, 2016
 */
public class MissingNumber {
    /*
     Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the
     array.

    For example,
    Given nums = [0, 1, 3] return 2.

    Note:
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space
    complexity?
     */
    public static int missingNumber(int[] nums) {
        int sum = 0, sum2 = nums.length;
        for(int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
            sum2 ^= i;
        }

        return sum ^ sum2;
    }
}

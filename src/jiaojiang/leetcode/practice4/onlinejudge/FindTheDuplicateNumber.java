package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 4, 2016
 */
public class FindTheDuplicateNumber {
    /*
     Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at
     least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

    Note:

        You must not modify the array (assume the array is read only).
        You must use only constant, O(1) extra space.
        Your runtime complexity should be less than O(n2).
        There is only one duplicate number in the array, but it could be repeated more than once.
     */

    /*
    Solution: it is equivalent to detect the start point of a cycle in linked list
     */
    public static int findDuplicate(int[] nums) {
//        int sum = nums[0];
//        int expectedSum = 0;
//        for (int i = 1; i < nums.length; i++) {
//            expectedSum ^= i;
//            sum ^= nums[i];
//        }
//
//        return expectedSum ^ sum;
        int p1 = 0, p2 = 0;

        do {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        } while (p1 != p2);

        p1 = 0;

        do {
            p1 = nums[p1];
            p2 = nums[p2];
        } while (p1 != p2);

        return p1;
    }
}

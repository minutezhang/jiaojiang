package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 25, 2015 11:00:35 PM
 */
public class RotateArray {
    /*
    Rotate an array of n elements to the right by k steps.

    For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

    Note:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

    [show hint]
    Hint:
    Could you do it in-place with O(1) extra space?
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private static void swap(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
}

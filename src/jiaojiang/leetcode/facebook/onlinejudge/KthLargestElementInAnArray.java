package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 7, 2016
 */
public class KthLargestElementInAnArray {
    /*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
    not the kth distinct element.

    For example,
    Given [3,2,1,5,6,4] and k = 2, return 5.

    Note:
    You may assume k is always valid, 1 ² k ² array's length.
     */
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length);
    }

    private static int findKthLargest(int[] nums, int k, int start, int end) {
        if (end == start + 1) {
            return nums[start];
        }

        int left, right;
        for (left = start, right = end - 2; left <= right;  ) {
            if (nums[left] < nums[end - 1]) {
                left++;
            } else {
                swap(nums, left, right);
                right--;
            }
        }

        if (end - left == k) {
            return nums[end - 1];
        }

        if (end - left < k) {
            return findKthLargest(nums, k - end + left, start, left);
        }
        return findKthLargest(nums, k, left, end - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

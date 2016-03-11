package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 10, 2016
 */
public class KthLargestElementInAnArray {
    /*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
    the kth distinct element.

    For example,
    Given [3,2,1,5,6,4] and k = 2, return 5.

    Note:
    You may assume k is always valid, 1 ² k ² array's length.
     */
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length);
    }

    private static int findKthLargest(int[] nums, int k, int start, int end) {
        if (end - start == 1) {
            return nums[start];
        }

        int pivot = nums[end - 1], split = start;

        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                int tmp = nums[split];
                nums[split] =  nums[i];
                nums[i] = tmp;
                split++;
            }
        }

        if (end - split == k) {
            return pivot; 
        }

        if (split == start) {
            return findKthLargest(nums, k, start, end - 1);
        }

        if (end - split > k) {
            return findKthLargest(nums, k, split, end);
        }

        return findKthLargest(nums, k - end + split, start, split);
    }
}

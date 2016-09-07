package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class MergeSortedArray {
    /*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    Note:
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
    from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
            nums1[i + j + 1] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }

        for (; j >= 0; j--) {
            nums1[j] = nums2[j];
        }
    }
}

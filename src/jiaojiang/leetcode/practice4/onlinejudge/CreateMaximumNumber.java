package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Apr 10, 2016
 */
public class CreateMaximumNumber {
    /*
     Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of
     length k <= m + n from digits of the two. The relative order of the digits from the same array must be
     preserved. Return an array of the k digits. You should try to optimize your time and space complexity.

    Example 1:

    nums1 = [3, 4, 6, 5]
    nums2 = [9, 1, 2, 5, 8, 3]
    k = 5
    return [9, 8, 6, 5, 3]

    Example 2:

    nums1 = [6, 7]
    nums2 = [6, 0, 4]
    k = 5
    return [6, 7, 6, 0, 4]

    Example 3:

    nums1 = [3, 9]
    nums2 = [8, 9]
    k = 3
    return [9, 8, 9]
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ret = new int[k];
        maxNumber(nums1, 0, nums2, 0, k, new int[k], 0, ret);
        return ret;
    }

    private static void maxNumber(int[] nums1, int start1, int[] nums2, int start2, int k, int[] buf, int i, int[] max) {
        if (k == 0) {
            if(compare(buf, max) > 0) {
                System.arraycopy(buf, 0, max, 0, buf.length);
            }
            return;
        }

        if (start1 < nums1.length) {
            buf[i] = nums1[start1];
            maxNumber(nums1, start1 + 1, nums2, start2, k - 1, buf, i + 1, max);
            buf[i] = 0;
            maxNumber(nums1, start1 + 1, nums2, start2, k, buf, i, max);
        }

        if (start2 < nums2.length) {
            buf[i] = nums2[start2];
            maxNumber(nums1, start1, nums2, start2 + 1, k - 1, buf, i + 1, max);
            buf[i] = 0;
            maxNumber(nums1, start1, nums2, start2 + 1, k, buf, i, max);
        }
    }

    private static int compare(int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return num1[i] - num2[i];
            }
        }

        return 0;
    }

    public static int[] maxNumberOpt(int[] nums1, int[] nums2, int k) {
        int[] buf = new int[k];
        int[] max = new int[k];

        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            merge(findK(nums1, i), findK(nums2, k - i), buf);
            if (compare(buf, max) > 0) {
                System.arraycopy(buf, 0, max, 0, buf.length);
            }
        }

        return max;
    }

    private static void merge(int[] nums1, int[] nums2, int[] ret) {
        merge(nums1, 0, nums2, 0, new int[nums1.length + nums2.length], ret);
    }

    private static void merge(int[] nums1, int i1, int[] nums2, int i2, int[] ret, int[] max) {
        if (i1 == nums1.length) {
            System.arraycopy(nums2, i2, ret, i1 + i2,  ret.length - i1 - i2);
        }

        if (i2 == nums2.length) {
            System.arraycopy(nums1, i1, ret, i1 + i2,  ret.length - i1 - i2);
        }

        if (i1 == nums1.length || i2 == nums2.length) {
            if (compare(ret, max) > 0) {
                System.arraycopy(ret, 0, max, 0, ret.length);
            }
            return;
        }

        if (nums1[i1] <= nums2[i2]) {
            ret[i1 + i2] = nums2[i2];
            merge(nums1, i1, nums2, i2 + 1, ret, max);
        }

        if (nums1[i1] >= nums2[i2]) {
            ret[i1 + i2] = nums1[i1];
            merge(nums1, i1 + 1, nums2, i2, ret, max);
        }
    }


    public static int[] maxNumber2Opt(int[] nums1, int[] nums2, int k) {
        int[] buf = new int[k];
        int[] max = new int[k];

        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            merge2(findK(nums1, i), findK(nums2, k - i), buf);
            if (greater(buf, 0, max, 0)) {
                System.arraycopy(buf, 0, max, 0, buf.length);
            }
        }

        return max;
    }

    private static void merge2(int[] nums1, int[] nums2, int[] ret) {
        for(int i1 = 0, i2 = 0; i1 < nums1.length || i2 < nums2.length;) {
            if (greater(nums1, i1, nums2, i2)) {
                ret[i1 + i2] = nums1[i1++];
            } else {
                ret[i1 + i2] = nums2[i2++];
            }
        }
    }

    private static boolean greater(int[] nums1, int i1, int[] nums2, int i2) {
        for (; i1 < nums1.length && i2 < nums2.length; i1++, i2++) {
            if (nums1[i1] < nums2[i2]) {
                return false;
            }
            if (nums1[i1] > nums2[i2]) {
                return true;
            }
        }

        return i1 < nums1.length;
    }

    private static int[] findK(int[] nums, int k) {
        int[] ret = new int[k];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (; !stack.isEmpty() && stack.peek() < nums[i] && stack.size() + nums.length - i > k; stack.pop());
            stack.push(nums[i]);
        }

        while (stack.size() > k) {
            stack.pop();
        }
        for (int i = k - 1; !stack.isEmpty(); ret[i--] = stack.pop());
        
        return ret;
    }
}

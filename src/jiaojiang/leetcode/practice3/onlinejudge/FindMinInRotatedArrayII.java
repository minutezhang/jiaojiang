package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

/**
 * @author: mizhang
 * @since: Nov 30, 2014 9:36:13 PM
 */
public class FindMinInRotatedArrayII {
    /*
    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.
    
    The array may contain duplicates.
     */

    public static int findMin(int[] num) {
        int start = 0, end = num.length - 1;

        while (start < end && num[start] >= num[end]) {

            if (num[start] == num[end]) {
                start++;
            } else {
                int mid = (start + end) >>> 1;
                if (num[mid] >= num[start]) {
                    start = mid + 1;
                } else if (num[mid] < num[mid - 1]) {
                    return num[mid];
                } else {
                    end = mid - 1;
                }
            }
        }

        return num[start];
    }

    public static void test() {
        Test.assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 0, 0, 0, 1, 2}));
        Test.assertEquals(0, findMin(new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7}));
        Test.assertEquals(1, findMin(new int[]{2, 1, 1, 1, 1, 2, 2, 2}));
        Test.assertEquals(1, findMin(new int[]{3, 1, 1, 1, 2, 3, 3, 3}));
        Test.assertEquals(2, findMin(new int[]{3, 3, 3, 3, 2, 3, 3, 3}));
        Test.assertEquals(1, findMin(new int[]{1, 1, 3, 1}));
        Test.assertEquals(1, findMin(new int[]{1, 1}));
        Test.assertEquals(0, findMin(new int[]{0, 0, 1, 1, 2, 0}));
    }

    public static void main(String[] args) {
        test();
    }
}

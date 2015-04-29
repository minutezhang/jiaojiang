package jiaojiang.leetcode.practice3.onlinejudge;

/**
 @author: zhang
 @date: Feb 19, 2015 2:44:40 PM
 */
public class FindMinimumInRotatedSortedArray {
    /*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    You may assume no duplicate exists in the array.
     */
    public static int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        while (num[start] > num[end]) {
            int mid = (start + end) >>> 1;

            if (start == mid) {
                return num[start + 1];
            }

            if (num[start] > num[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return num[start];
    }


    public static int findMin2(int[] num) {
        int start = 0, end = num.length - 1;

        while (start < end && num[start] > num[end]) {
            int mid = (start + end) >>> 1;
            if (num[mid] < num[start]) {
                if (num[mid] < num[mid - 1]) {
                    return num[mid];
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return num[start];
    }
}

package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/17/15 3:51 PM
 */
public class SearchForARange {
    /*
    Given a sorted array of integers, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
     */
    public static int[] searchRange(int[] A, int target) {
        int start = 0, end = A.length - 1, mid = 0;
        int[] ret = new int[]{-1, -1};

        while (start <= end) {
            mid = (start + end) >>> 1;
            if (A[mid] == target) {
                break;
            }

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start > end) {
            return ret;
        }

        int newStart = mid, newEnd = mid;
        while (start <= newEnd) {
            mid = (start + newEnd) >>> 1;
            if (A[mid] == target && (mid == 0 || A[mid - 1] != target)) {
                ret[0] = mid;
                break;
            }

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                newEnd = mid - 1;
            }
        }

        while (newStart <= end) {
            mid = (newStart + end) >>> 1;
            if (A[mid] == target && (mid == A.length - 1 || A[mid + 1] != target)) {
                ret[1] = mid;
                break;
            }

            if (A[mid] > target) {
                end = mid - 1;
            } else {
                newStart = mid + 1;
            }
        }


        return ret;
    }
}

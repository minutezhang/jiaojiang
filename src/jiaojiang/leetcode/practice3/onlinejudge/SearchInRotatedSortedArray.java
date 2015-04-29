package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/6/15 3:54 PM
 */
public class SearchInRotatedSortedArray {
    /*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 3 4 5 6 7 might become 4 5 6 7 0 1 2 3).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.
     */
    public static int search(int[] A, int target) {
        int start = 0, end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < target) {
                if (A[mid] > A[start] || target <= A[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (A[mid] < A[start] || target >= A[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static int search2(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < target && (A[mid] > A[start] || target <= A[end]) || A[mid] > target && A[mid] >= A[start] && target < A[start]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

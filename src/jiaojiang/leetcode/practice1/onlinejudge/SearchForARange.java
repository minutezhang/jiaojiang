package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 19, 2013 11:08:54 PM
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
        return new int[] {findLeft(A, target), findRight(A, target)};
    }

    public static int findLeft(int[] A, int target) {
        int i = 0, j = A.length - 1;

        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (A[mid] == target && mid == 0 || A[mid] == target && A[mid - 1] < target) {
                return mid;
            }

            if (A[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return -1;
    }

    public static int findRight(int[] A, int target) {
        int i = 0, j = A.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;

            if(A[mid] == target && mid == A.length - 1 || A[mid] == target && A[mid + 1] > target) {
                return mid;
            }

            if (A[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }


    public static int[] searchRange2(int[] A, int target) {
        int i = 0, j = A.length - 1;
        int[] range = new int[]{-1, -1};

        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (A[mid] == target && mid == 0 || A[mid] == target && A[mid - 1] < target) {
                range[0] = mid;
                break;
            }

            if (A[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1; 
            }
        }

        if (range[0] == -1) {
            return range;
        }

        j = A.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;

            if(A[mid] == target && mid == A.length - 1 || A[mid] == target && A[mid + 1] > target) {
                range[1] = mid;
                return range;
            }

            if (A[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return range;
    }

    public static void test() {
//        System.out.printTestln(findLeft(new int[]{5, 7, 7, 8, 8, 10}, 8));
//        System.out.printTestln(findRight(new int[]{5, 7, 7, 8, 8, 10}, 8));
        int[] range = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(range[0] + " : " + range[1]);

        int[] range2 = searchRange(new int[]{1}, 8);
        System.out.println(range2[0] + " : " + range2[1]);
    }

    public static void main(String[] args) {
        test();
    }
}

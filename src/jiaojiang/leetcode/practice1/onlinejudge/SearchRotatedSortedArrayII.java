package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 18, 2013 11:32:45 PM
 */
public class SearchRotatedSortedArrayII {
    /*
    Follow up for "Search in Rotated Sorted Array":
     What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

    Write a function to determine if a given target is in the array.
     */
    public static boolean search(int[] A, int target) {
        return search(A, target, 0, A.length - 1); 
    }

    public static boolean search(int[] A, int target, int start, int end) {
        int i = start, j = end;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (A[mid] == target) {
                return true;
            }
            int lmid = mid, rmid = mid;
            while (lmid >= start && A[lmid] == A[mid]) {
                lmid--;
            }

            if (lmid < start) {
                return search(A, target, mid + 1, end);
            }

            while (rmid <= end && A[rmid] == A[mid]) {
                rmid++;
            }

            if (rmid > end) {
                return search(A, target, start, mid - 1);
            }

            if (A[mid] < target) {
                // if (A[mid] < A[j] && A[j] >= target) binary search right hand
                // if (A[mid] < A[j] && A[j] < target) rotated search left hand
                // if (A[mid] > A[j]) rotated search right hand
                if (A[mid] > A[j]) {
                    return search(A, target, rmid, j);
                } else if (A[j] >= target) {
                    i = rmid;
                } else{
                    return search(A, target, i, lmid);
                }
            } else {
                // if (A[mid] > A[i] && A[i] <= target) binary search left hand
                // if (A[mid] > A[i] && A[i] > target) rotated binary search right hand
                // if (A[mid] < A[i]) rotated binary search left hand
                if (A[mid] < A[i]) {
                    return search(A, target, i, lmid);
                }
                else if (A[i] <= target) {
                    j = lmid;
                } else{
                    return search(A, target, rmid, j);
                }
            }
        }

        return false;
    }

    public static void test() {
        System.out.println(search(new int[] {4, 5, 6, 7, 7, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[] {4, 5, 6, 6, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[] {4, 5, 5, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 0, 0, 1, 2}, 4));
        System.out.println(search(new int[] {3, 4, 1, 1, 1}, 1));
    }

    public static void main(String[] args) {
        test();
    }
}
